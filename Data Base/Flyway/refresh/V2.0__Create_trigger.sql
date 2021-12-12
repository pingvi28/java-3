--Trigger function
--RETURNS тип_результата

CREATE OR REPLACE FUNCTION trigger_func() RETURNS TRIGGER AS $func$
    BEGIN REFRESH MATERIALIZED VIEW mat_view;
    RETURN NULL;
    END;
    $func$ LANGUAGE plpgsql;


-- Triggers
--Триггер с пометкой FOR EACH STATEMENT вызывается только один раз для конкретной операции, вне зависимости от того, как много строк она изменила

CREATE TRIGGER trigger_I_U_D AFTER INSERT OR UPDATE OR DELETE ON firstdb FOR EACH STATEMENT EXECUTE PROCEDURE trigger_func();
CREATE TRIGGER trigger_I_U_D AFTER INSERT OR UPDATE OR DELETE ON test_table FOR EACH STATEMENT EXECUTE PROCEDURE trigger_func();

