-- Magazyny
INSERT INTO warehouse (warehouse_name, address, capacity) VALUES ('Magazyn Główny', 'ul. Przemysłowa 1, Warszawa', 10000);
INSERT INTO warehouse (warehouse_name, address, capacity) VALUES ('Magazyn Zapasowy', 'ul. Boczna 2, Kraków', 5000);
-- NOWY MAGAZYN TESTOWY O POJEMNOŚCI 2 (ID będzie 3)
INSERT INTO warehouse (warehouse_name, address, capacity) VALUES ('Magazyn Mały Testowy', 'ul. Testowa 1', 2);

-- Kategorie
INSERT INTO category (type_name, description, warehouse_war_id) VALUES ('Elektronika', 'Sprzęt RTV i AGD', 1);
INSERT INTO category (type_name, description, warehouse_war_id) VALUES ('Narzędzia', 'Narzędzia ręczne i elektronarzędzia', 1);
INSERT INTO category (type_name, description, warehouse_war_id) VALUES ('Odzież', 'Ubrania robocze', 2);
-- NOWA KATEGORIA PRZYPISANA DO MAŁEGO MAGAZYNU (ID kategorii będzie 4, warehouse_war_id = 3)
INSERT INTO category (type_name, description, warehouse_war_id) VALUES ('Testowa', 'Kategoria do testowania', 3);


-- Klienci
INSERT INTO customer (name, surname, email, phone_number, address) VALUES ('Jan', 'Kowalski', 'jan.kowalski@example.com', '123456789', 'ul. Kwiatowa 3, Poznań');
INSERT INTO customer (name, surname, email, phone_number, address) VALUES ('Anna', 'Nowak', 'anna.nowak@example.com', '987654321', 'ul. Leśna 4, Gdańsk');

-- Faktury
INSERT INTO invoice (invoice_number, date_of_issue, total_sum, customer_id) VALUES ('FV/2023/10/01', '2023-10-01', 299.98, 1);
INSERT INTO invoice (invoice_number, date_of_issue, total_sum, customer_id) VALUES ('FV/2023/10/02', '2023-10-02', 49.99, 2);
INSERT INTO invoice (invoice_number, date_of_issue, total_sum, customer_id) VALUES ('FV/2023/10/03', '2023-10-05', 69.98, 1);

-- Produkty
-- Dodajemy kolumnę 'invoice_id', aby przypisać produkt do konkretnej faktury
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-EL-001', 'Nowy', 199.99, 1, 1);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-EL-002', 'Używany', 99.99, 1, 1);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-NA-001', 'Nowy', 49.99, 2, 2);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-OD-001', 'Nowy', 29.99, 3, 3);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-OD-002', 'Nowy', 39.99, 3, 3);

-- NOWE PRODUKTY TESTOWE ZAPEŁNIAJĄCE MAŁY MAGAZYN (przypisane do category_id = 4, invoice_id = null bo nie na fakturze)
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('TEST-1', 'Nowy', 10.00, 4, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('TEST-2', 'Nowy', 10.00, 4, null);
