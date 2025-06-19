# Como Subir o Código para o GitHub

## Passo 1: Instalar o Git

1. **Baixe o Git**:
   - Acesse: https://git-scm.com/download/win
   - Baixe a versão para Windows
   - Execute o instalador e siga as instruções

2. **Configure o Git** (após instalar):
   ```bash
   git config --global user.name "Seu Nome"
   git config --global user.email "seu.email@exemplo.com"
   ```

## Passo 2: Criar Repositório no GitHub

1. **Acesse o GitHub**:
   - Vá para: https://github.com
   - Faça login na sua conta

2. **Crie um novo repositório**:
   - Clique no botão "+" no canto superior direito
   - Selecione "New repository"
   - Nome do repositório: `agenda-contatos-java-poo`
   - Descrição: `Sistema de agenda de contatos em Java aplicando conceitos de POO`
   - Deixe público ou privado (sua escolha)
   - **NÃO** marque "Add a README file" (já temos um)
   - Clique em "Create repository"

## Passo 3: Subir o Código

Após instalar o Git, abra o PowerShell na pasta do projeto e execute os comandos:

```bash
# Inicializar o repositório Git local
git init

# Adicionar todos os arquivos
git add .

# Fazer o primeiro commit
git commit -m "Primeira versão: Agenda de Contatos Java POO"

# Adicionar o repositório remoto (substitua SEU_USUARIO pelo seu nome de usuário do GitHub)
git remote add origin https://github.com/SEU_USUARIO/agenda-contatos-java-poo.git

# Enviar o código para o GitHub
git branch -M main
git push -u origin main
```

## Passo 4: Verificar se Deu Certo

1. Acesse seu repositório no GitHub
2. Você deve ver todos os arquivos:
   - `Endereco.java`
   - `Contato.java`
   - `ContatoPessoal.java`
   - `ContatoProfissional.java`
   - `Agenda.java`
   - `Main.java`
   - `README.md`
   - `.gitignore`

## Estrutura do Projeto no GitHub

```
agenda-contatos-java-poo/
├── Endereco.java           # Classe para endereços
├── Contato.java            # Classe base para contatos
├── ContatoPessoal.java     # Contatos pessoais (herda de Contato)
├── ContatoProfissional.java # Contatos profissionais (herda de Contato)
├── Agenda.java             # Gerenciador de contatos
├── Main.java               # Interface do usuário
├── README.md               # Documentação
├── .gitignore              # Arquivos a serem ignorados
└── INSTRUCOES_GITHUB.md    # Este arquivo
```

## Comandos Úteis para o Futuro

```bash
# Ver status dos arquivos
git status

# Ver histórico de commits
git log

# Fazer alterações e subir novamente
git add .
git commit -m "Descrição das alterações"
git push

# Baixar alterações do GitHub
git pull
```

## Dúvidas?

Se tiver problemas:
1. Verifique se o Git foi instalado corretamente
2. Confirme se o repositório foi criado no GitHub
3. Verifique se o nome de usuário está correto no comando `git remote add origin`

## Próximos Passos

Após subir o código:
1. Adicione uma descrição no repositório
2. Configure as tags (topics) para facilitar a busca
3. Compartilhe o link do repositório
4. Considere adicionar um arquivo de licença se quiser 