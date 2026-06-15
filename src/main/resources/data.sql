-- Magazyny
INSERT INTO warehouse (warehouse_name, address, capacity) VALUES ('Magazyn Główny', 'ul. Przemysłowa 1, Warszawa', 10000);
INSERT INTO warehouse (warehouse_name, address, capacity) VALUES ('Magazyn Zapasowy', 'ul. Boczna 2, Kraków', 5000);
-- NOWY MAGAZYN TESTOWY O POJEMNOŚCI 2 (ID będzie 3)
INSERT INTO warehouse (warehouse_name, address, capacity) VALUES ('Magazyn Mały Testowy', 'ul. Testowa 1', 2);

-- Kategorie
-- Kategorie dla Magazynu 1
INSERT INTO category (type_name, description, warehouse_war_id) VALUES ('Elektronika', 'Sprzęt RTV i AGD', 1);
INSERT INTO category (type_name, description, warehouse_war_id) VALUES ('Narzędzia', 'Narzędzia ręczne i elektronarzędzia', 1);
INSERT INTO category (type_name, description, warehouse_war_id) VALUES ('Materiały budowlane', 'Cegły, cement, piasek', 1);

-- Kategorie dla Magazynu 2
INSERT INTO category (type_name, description, warehouse_war_id) VALUES ('Odzież', 'Ubrania robocze', 2);
INSERT INTO category (type_name, description, warehouse_war_id) VALUES ('BHP', 'Kaski, okulary, rękawice', 2);

-- NOWA KATEGORIA PRZYPISANA DO MAŁEGO MAGAZYNU (ID kategorii będzie 6, warehouse_war_id = 3)
INSERT INTO category (type_name, description, warehouse_war_id) VALUES ('Testowa', 'Kategoria do testowania', 3);


-- Klienci
INSERT INTO customer (name, surname, email, phone_number, address) VALUES ('Jan', 'Kowalski', 'jan.kowalski@example.com', '123456789', 'ul. Kwiatowa 3, Poznań');
INSERT INTO customer (name, surname, email, phone_number, address) VALUES ('Anna', 'Nowak', 'anna.nowak@example.com', '987654321', 'ul. Leśna 4, Gdańsk');

-- Faktury
INSERT INTO invoice (invoice_number, date_of_issue, total_sum, customer_id) VALUES ('FV/2023/10/01', '2023-10-01', 299.98, 1);
INSERT INTO invoice (invoice_number, date_of_issue, total_sum, customer_id) VALUES ('FV/2023/10/02', '2023-10-02', 49.99, 2);
INSERT INTO invoice (invoice_number, date_of_issue, total_sum, customer_id) VALUES ('FV/2023/10/03', '2023-10-05', 69.98, 1);

-- Produkty
-- Elektronika (kat_id = 1, Magazyn Główny) -> zrobimy np. 12 sztuk
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-EL-001', 'Nowy', 199.99, 1, 1);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-EL-002', 'Używany', 99.99, 1, 1);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-EL-003', 'Nowy', 150.00, 1, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-EL-004', 'Nowy', 150.00, 1, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-EL-005', 'Nowy', 150.00, 1, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-EL-006', 'Nowy', 200.00, 1, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-EL-007', 'Nowy', 200.00, 1, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-EL-008', 'Nowy', 200.00, 1, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-EL-009', 'Nowy', 200.00, 1, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-EL-010', 'Nowy', 250.00, 1, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-EL-011', 'Nowy', 250.00, 1, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-EL-012', 'Nowy', 250.00, 1, null);

-- Narzędzia (kat_id = 2, Magazyn Główny) -> zrobimy np. 8 sztuk
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-NA-001', 'Nowy', 49.99, 2, 2);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-NA-002', 'Nowy', 55.00, 2, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-NA-003', 'Nowy', 55.00, 2, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-NA-004', 'Nowy', 60.00, 2, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-NA-005', 'Nowy', 60.00, 2, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-NA-006', 'Nowy', 60.00, 2, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-NA-007', 'Nowy', 60.00, 2, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-NA-008', 'Nowy', 100.00, 2, null);

-- Materiały budowlane (kat_id = 3, Magazyn Główny) -> zrobimy 15 sztuk
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-MB-001', 'Nowy', 15.00, 3, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-MB-002', 'Nowy', 15.00, 3, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-MB-003', 'Nowy', 15.00, 3, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-MB-004', 'Nowy', 15.00, 3, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-MB-005', 'Nowy', 15.00, 3, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-MB-006', 'Nowy', 20.00, 3, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-MB-007', 'Nowy', 20.00, 3, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-MB-008', 'Nowy', 20.00, 3, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-MB-009', 'Nowy', 20.00, 3, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-MB-010', 'Nowy', 20.00, 3, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-MB-011', 'Nowy', 25.00, 3, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-MB-012', 'Nowy', 25.00, 3, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-MB-013', 'Nowy', 25.00, 3, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-MB-014', 'Nowy', 25.00, 3, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-MB-015', 'Nowy', 25.00, 3, null);

-- Odzież (kat_id = 4, Magazyn Zapasowy) -> zrobimy 5 sztuk
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-OD-001', 'Nowy', 29.99, 4, 3);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-OD-002', 'Nowy', 39.99, 4, 3);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-OD-003', 'Nowy', 39.99, 4, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-OD-004', 'Nowy', 39.99, 4, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-OD-005', 'Nowy', 49.99, 4, null);

-- BHP (kat_id = 5, Magazyn Zapasowy) -> zrobimy 7 sztuk
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-BHP-001', 'Nowy', 12.50, 5, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-BHP-002', 'Nowy', 12.50, 5, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-BHP-003', 'Nowy', 12.50, 5, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-BHP-004', 'Nowy', 12.50, 5, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-BHP-005', 'Nowy', 15.00, 5, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-BHP-006', 'Nowy', 15.00, 5, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('SN-BHP-007', 'Nowy', 25.00, 5, null);


-- NOWE PRODUKTY TESTOWE ZAPEŁNIAJĄCE MAŁY MAGAZYN (przypisane do category_id = 6, invoice_id = null)
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('TEST-1', 'Nowy', 10.00, 6, null);
INSERT INTO product (serial_number, status, price, category_id, invoice_id) VALUES ('TEST-2', 'Nowy', 10.00, 6, null);