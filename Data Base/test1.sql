\set c2 random(1,1000)
SELECT * FROM index_test WHERE c2=:c2::varchar;