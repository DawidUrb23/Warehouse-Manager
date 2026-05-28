-- Magazyny
INSERT INTO warehouse (warehouse_name, address, capacity) VALUES ('Magazyn Główny', 'ul. Przemysłowa 1, Warszawa', 10000);
INSERT INTO warehouse (warehouse_name, address, capacity) VALUES ('Magazyn Zapasowy', 'ul. Boczna 2, Kraków', 5000);

-- Kategorie
-- Uwaga: JPA/Hibernate zamienia camelCase na snake_case w nazwach kolumn.
-- Dlatego typeName w klasie Category odpowiada kolumnie type_name w bazie.
INSERT INTO category (type_name, description, warehouse_war_id) VALUES ('Elektronika', 'Sprzęt RTV i AGD', 1);
INSERT INTO category (type_name, description, warehouse_war_id) VALUES ('Narzędzia', 'Narzędzia ręczne i elektronarzędzia', 1);
INSERT INTO category (type_name, description, warehouse_war_id) VALUES ('Odzież', 'Ubrania robocze', 2);

-- Klienci
INSERT INTO customer (name, surname, email, phone_number, address) VALUES ('Jan', 'Kowalski', 'jan.kowalski@example.com', '123456789', 'ul. Kwiatowa 3, Poznań');
INSERT INTO customer (name, surname, email, phone_number, address) VALUES ('Anna', 'Nowak', 'anna.nowak@example.com', '987654321', 'ul. Leśna 4, Gdańsk');

-- Faktury
INSERT INTO invoice (invoice_number, date_of_issue, total_sum, customer_id) VALUES ('FV/2023/10/01', '2023-10-01', 1500.50, 1);
INSERT INTO invoice (invoice_number, date_of_issue, total_sum, customer_id) VALUES ('FV/2023/10/02', '2023-10-02', 250.00, 2);
INSERT INTO invoice (invoice_number, date_of_issue, total_sum, customer_id) VALUES ('FV/2023/10/03', '2023-10-05', 3000.00, 1);

-- Produkty
INSERT INTO product (serial_number, status, price, category_id) VALUES ('SN-EL-001', 'Nowy', 199.99, 1);
INSERT INTO product (serial_number, status, price, category_id) VALUES ('SN-EL-002', 'Używany', 99.99, 1);
INSERT INTO product (serial_number, status, price, category_id) VALUES ('SN-NA-001', 'Nowy', 49.99, 2);
INSERT INTO product (serial_number, status, price, category_id) VALUES ('SN-OD-001', 'Nowy', 29.99, 3);
INSERT INTO product (serial_number, status, price, category_id) VALUES ('SN-OD-002', 'Nowy', 39.99, 3);

-- Tabela łącząca produkty z fakturami
INSERT INTO invoice_product (invoice_id, product_id) VALUES (1, 1);
INSERT INTO invoice_product (invoice_id, product_id) VALUES (1, 2);
INSERT INTO invoice_product (invoice_id, product_id) VALUES (2, 3);
INSERT INTO invoice_product (invoice_id, product_id) VALUES (3, 4);
INSERT INTO invoice_product (invoice_id, product_id) VALUES (3, 5);
