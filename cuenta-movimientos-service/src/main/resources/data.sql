-- cuenta
INSERT INTO cuenta (numero_cuenta, tipo_cuenta, saldo, estado, cliente_id) VALUES
('1234567890', 'Ahorros', 1000.00, TRUE, 1),
('9876543210', 'Corriente', 500.00, TRUE, 2);

-- movimiento
INSERT INTO movimiento (fecha, tipo_movimiento, valor, saldo, cuenta_id) VALUES
('2024-06-01 10:00:00', 'Deposito', 200.00, 1200.00, 1),
('2024-06-02 12:00:00', 'Retiro', 100.00, 1100.00, 1),
('2024-06-03 14:00:00', 'Deposito', 50.00, 550.00, 2),
('2024-06-04 16:00:00', 'Retiro', 30.00, 520.00, 2);