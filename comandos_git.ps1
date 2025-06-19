# Script para subir código para o GitHub
# Execute este script após instalar o Git

Write-Host "========================================" -ForegroundColor Green
Write-Host "    SUBINDO CODIGO PARA O GITHUB" -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Green
Write-Host ""

# Verificar se o Git está instalado
try {
    $gitVersion = git --version
    Write-Host "Git encontrado: $gitVersion" -ForegroundColor Green
} catch {
    Write-Host "ERRO: Git não está instalado!" -ForegroundColor Red
    Write-Host ""
    Write-Host "Por favor, instale o Git primeiro:" -ForegroundColor Yellow
    Write-Host "1. Acesse: https://git-scm.com/download/win" -ForegroundColor Yellow
    Write-Host "2. Baixe e instale o Git" -ForegroundColor Yellow
    Write-Host "3. Execute este script novamente" -ForegroundColor Yellow
    Write-Host ""
    Read-Host "Pressione Enter para sair"
    exit 1
}

Write-Host ""
Write-Host "1. Inicializando repositório Git local..." -ForegroundColor Cyan
git init

Write-Host ""
Write-Host "2. Adicionando todos os arquivos..." -ForegroundColor Cyan
git add .

Write-Host ""
Write-Host "3. Fazendo o primeiro commit..." -ForegroundColor Cyan
git commit -m "Primeira versão: Agenda de Contatos Java POO"

Write-Host ""
Write-Host "4. Adicionando repositório remoto..." -ForegroundColor Cyan
git remote add origin https://github.com/Filipe07H/TrabalhoJavaPOO.git

Write-Host ""
Write-Host "5. Configurando branch principal..." -ForegroundColor Cyan
git branch -M main

Write-Host ""
Write-Host "6. Enviando código para o GitHub..." -ForegroundColor Cyan
git push -u origin main

Write-Host ""
Write-Host "========================================" -ForegroundColor Green
Write-Host "    PROCESSO CONCLUÍDO!" -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Green
Write-Host ""
Write-Host "Seu código foi enviado para:" -ForegroundColor Yellow
Write-Host "https://github.com/Filipe07H/TrabalhoJavaPOO" -ForegroundColor Yellow
Write-Host ""
Write-Host "Verifique se todos os arquivos estão lá!" -ForegroundColor Yellow
Write-Host ""
Read-Host "Pressione Enter para sair" 