CREATE MATERIALIZED VIEW mat_view (first_letter, count) AS
        SELECT parid, first_name, last_name, email, index
        FROM firstdb f
        RIGHT JOIN test_table t
        ON f.id = t.parid;