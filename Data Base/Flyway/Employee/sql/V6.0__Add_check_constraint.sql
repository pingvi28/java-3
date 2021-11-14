ALTER TABLE employee ADD CONSTRAINT 
proper_email CHECK (email ~* '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$');

ALTER TABLE employee ADD CONSTRAINT 
phone_size_check CHECK(LENGTH(phone_number) >= 6 AND LENGTH(phone_number) <= 14); 

ALTER TABLE employee ADD CONSTRAINT 
check_nn_email CHECK(email is not null);
