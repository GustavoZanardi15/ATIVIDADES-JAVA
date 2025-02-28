let xBolinha = 300;
let yBolinha = 200;
let diametro = 30;
let vxBolinha = 5;
let vyBolinha = 5;
let raio = diametro / 2;
let xRaquete = 10;
let yRaquete = 150;
let compRaquete = 10;
let largRaquete = 100;
let xRaqueteOponente = 580;
let yRaqueteOponente = 150;
let compRaqueteOponente= 10;
let largRaqueteOponente = 100;
let meusPontos = 0;  
let pontosDoOponente = 0;  

function setup() {
    createCanvas(600, 400);
}

function draw() {
    background(0);

    CriarBolinha();
    VerificarColisaoBorda();
    MoverRaquete();
    MoverRaqueteOponente();
    VerificarColisaoRaquete();
    VerificarColisaoRaqueteOponente();
    incluiPlacar();
   
}

function CriarBolinha() {
    circle(xBolinha, yBolinha, diametro);
    xBolinha += vxBolinha;
    yBolinha += vyBolinha;
}

function VerificarColisaoBorda() {
    if (xBolinha + raio > width) {
        meusPontos++;
        resetBolinha();
    }
    if (xBolinha - raio < 0) {
        pontosDoOponente++;
        resetBolinha();
    }
    if (yBolinha + raio > height || yBolinha - raio < 0) {
        vyBolinha *= -1; 
    }
}

function MoverRaquete() {
    rect(xRaquete, yRaquete, compRaquete, largRaquete);
    
    if (keyIsDown(87) && yRaquete > 0) {
        yRaquete -= 10; 
    }
    if (keyIsDown(83) && yRaquete < height - largRaquete) {
        yRaquete += 10; 
    }
}

function MoverRaqueteOponente() {
    rect(xRaqueteOponente, yRaqueteOponente, compRaqueteOponente, largRaqueteOponente);

    if (keyIsDown(UP_ARROW) && yRaqueteOponente > 0) {
        yRaqueteOponente -= 10; 
    }
    if (keyIsDown(DOWN_ARROW) && yRaqueteOponente < height - largRaqueteOponente) {
        yRaqueteOponente += 10; 
    }
}

function VerificarColisaoRaquete() {
    if (xBolinha - raio < xRaquete + compRaquete && 
        yBolinha > yRaquete && 
        yBolinha < yRaquete + largRaquete) {
        vxBolinha *= -1; 
    }
}

function VerificarColisaoRaqueteOponente() {
    if (xBolinha + raio > xRaqueteOponente && 
        yBolinha > yRaqueteOponente && 
        yBolinha < yRaqueteOponente + largRaqueteOponente) {
        vxBolinha *= -1; 
    }
}

function incluiPlacar() {
    fill(255);
    textSize(32);
    text(meusPontos, 278, 50); 
    text(pontosDoOponente, 321, 50);
}

function resetBolinha() {
    xBolinha = width / 2;
    yBolinha = height / 2;
    vxBolinha = -vxBolinha; 

}
