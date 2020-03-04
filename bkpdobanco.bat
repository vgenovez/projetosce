REM IP do Servidor do PostgreSQL:
SET PGHOST=localhost

REM Porta de acesso ao PostgreSQL:
SET PGPORT=5432

REM Base de Dados que será feito backup:
SET PGDATABASE=sce

REM Usuário da base de dados:
SET PGUSER=postgres

REM Senha da base de dados
SET PGPASSWORD=senha

REM Diretório de destino do arquivo de Backup:
SET DESTDIR=C:\bkp\

pg_dump.exe -F c -b -v -f %DESTDIR%%PGDATABASE%%date:~0,2%%date:~3,2%%date:~6,4%%time:~0,2%%time:~3,2%.backup

pause