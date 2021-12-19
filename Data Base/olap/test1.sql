\set id random(1,10000)
begin;
SELECT t.*
       FROM public.olap t
       WHERE (scores >= 60)
       ORDER BY scores DESC, last_name
       LIMIT 100;
end;