@echo off
echo ========================================
echo    SUBINDO CODIGO PARA O GITHUB
echo ========================================
echo.

echo Verificando se o Git esta instalado...
git --version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERRO: Git nao esta instalado!
    echo.
    echo Por favor, instale o Git primeiro:
    echo 1. Acesse: https://git-scm.com/download/win
    echo 2. Baixe e instale o Git
    echo 3. Execute este script novamente
    echo.
    pause
    exit /b 1
)

echo Git encontrado! Iniciando processo...
echo.

echo 1. Inicializando repositorio Git local...
git init

echo.
echo 2. Adicionando todos os arquivos...
git add .

echo.
echo 3. Fazendo o primeiro commit...
git commit -m "Primeira versao: Agenda de Contatos Java POO"

echo.
echo 4. Adicionando repositorio remoto...
git remote add origin https://github.com/Filipe07H/TrabalhoJavaPOO.git

echo.
echo 5. Configurando branch principal...
git branch -M main

echo.
echo 6. Enviando codigo para o GitHub...
git push -u origin main

echo.
echo ========================================
echo    PROCESSO CONCLUIDO!
echo ========================================
echo.
echo Seu codigo foi enviado para:
echo https://github.com/Filipe07H/TrabalhoJavaPOO
echo.
echo Verifique se todos os arquivos estao la!
echo.
pause 