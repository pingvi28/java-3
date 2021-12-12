setlocal
cd /d "C:\Program Files\PostgreSQL\13\bin"
set PGPASSWORD=1234567890
.\psql -h rc1c-edkx6axwh3chvb4k.mdb.yandexcloud.net -p 6432 -U Di -d FirstDB -f "C:\Users\79179\Desktop\Refresh\script.sql"
endlocal
