-- Insertar 10 cuentas bancarias
INSERT INTO public.cuenta (saldo, id, tipo_cuenta, numero_cuenta, tipo, titular) VALUES
(10000.50, 1, 'AHORROS', '1234567890', 'PERSONAL', 'Juan Pérez'),
(25000.75, 2, 'CORRIENTE', '2345678901', 'EMPRESARIAL', 'Maria Gómez'),
(5000.00, 3, 'AHORROS', '3456789012', 'PERSONAL', 'Carlos Rodríguez'),
(150000.00, 4, 'CORRIENTE', '4567890123', 'EMPRESARIAL', 'Ana Martínez'),
(7000.30, 5, 'AHORROS', '5678901234', 'PERSONAL', 'Luis Fernández'),
(32000.90, 6, 'CORRIENTE', '6789012345', 'EMPRESARIAL', 'Sofía Ramírez'),
(4200.10, 7, 'AHORROS', '7890123456', 'PERSONAL', 'Ricardo Torres'),
(78000.00, 8, 'CORRIENTE', '8901234567', 'EMPRESARIAL', 'Gabriela Ortega'),
(9600.60, 9, 'AHORROS', '9012345678', 'PERSONAL', 'Fernando Castillo'),
(11000.25, 10, 'CORRIENTE', '0123456789', 'EMPRESARIAL', 'Laura Mendoza');

-- Insertar 50 transacciones con distintos tipos
INSERT INTO public.transacciones (monto, cuenta_id, fecha, id, tipo) VALUES
(500.00, 1, '2025-03-28 10:00:00', 1, 'DEPOSITO_SUCURSAL'),
(1000.00, 2, '2025-03-28 11:00:00', 2, 'DEPOSITO_CAJERO'),
(200.00, 3, '2025-03-28 12:00:00', 3, 'DEPOSITO_OTRA_CUENTA'),
(300.50, 4, '2025-03-28 13:00:00', 4, 'COMPRA_ESTABLECIMIENTO'),
(400.75, 5, '2025-03-28 14:00:00', 5, 'COMPRA_WEB'),
(150.25, 6, '2025-03-28 15:00:00', 6, 'RETIRO_CAJERO'),
(250.30, 7, '2025-03-28 16:00:00', 7, 'DEPOSITO_SUCURSAL'),
(1800.00, 8, '2025-03-28 17:00:00', 8, 'DEPOSITO_CAJERO'),
(90.00, 9, '2025-03-28 18:00:00', 9, 'DEPOSITO_OTRA_CUENTA'),
(600.60, 10, '2025-03-28 19:00:00', 10, 'COMPRA_ESTABLECIMIENTO'),
(500.00, 1, '2025-03-28 20:00:00', 11, 'COMPRA_WEB'),
(700.90, 2, '2025-03-28 21:00:00', 12, 'RETIRO_CAJERO'),
(450.00, 3, '2025-03-28 22:00:00', 13, 'DEPOSITO_SUCURSAL'),
(2500.00, 4, '2025-03-28 23:00:00', 14, 'DEPOSITO_CAJERO'),
(350.60, 5, '2025-03-28 10:30:00', 15, 'DEPOSITO_OTRA_CUENTA'),
(420.75, 6, '2025-03-28 11:30:00', 16, 'COMPRA_ESTABLECIMIENTO'),
(500.00, 7, '2025-03-28 12:30:00', 17, 'COMPRA_WEB'),
(600.30, 8, '2025-03-28 13:30:00', 18, 'RETIRO_CAJERO'),
(300.20, 9, '2025-03-28 14:30:00', 19, 'DEPOSITO_SUCURSAL'),
(1000.00, 10, '2025-03-28 15:30:00', 20, 'DEPOSITO_CAJERO'),
(75.00, 1, '2025-03-28 16:30:00', 21, 'DEPOSITO_OTRA_CUENTA'),
(280.40, 2, '2025-03-28 17:30:00', 22, 'COMPRA_ESTABLECIMIENTO'),
(340.90, 3, '2025-03-28 18:30:00', 23, 'COMPRA_WEB'),
(420.00, 4, '2025-03-28 19:30:00', 24, 'RETIRO_CAJERO'),
(600.80, 5, '2025-03-28 20:30:00', 25, 'DEPOSITO_SUCURSAL'),
(520.90, 6, '2025-03-28 21:30:00', 26, 'DEPOSITO_CAJERO'),
(700.00, 7, '2025-03-28 22:30:00', 27, 'DEPOSITO_OTRA_CUENTA'),
(500.50, 8, '2025-03-28 23:30:00', 28, 'COMPRA_ESTABLECIMIENTO'),
(150.75, 9, '2025-03-28 10:45:00', 29, 'COMPRA_WEB'),
(200.90, 10, '2025-03-28 11:45:00', 30, 'RETIRO_CAJERO'),
(700.00, 1, '2025-03-28 12:45:00', 31, 'DEPOSITO_SUCURSAL'),
(800.00, 2, '2025-03-28 13:45:00', 32, 'DEPOSITO_CAJERO'),
(900.50, 3, '2025-03-28 14:45:00', 33, 'DEPOSITO_OTRA_CUENTA'),
(600.75, 4, '2025-03-28 15:45:00', 34, 'COMPRA_ESTABLECIMIENTO'),
(320.90, 5, '2025-03-28 16:45:00', 35, 'COMPRA_WEB'),
(100.10, 6, '2025-03-28 17:45:00', 36, 'RETIRO_CAJERO'),
(450.60, 7, '2025-03-28 18:45:00', 37, 'DEPOSITO_SUCURSAL'),
(780.40, 8, '2025-03-28 19:45:00', 38, 'DEPOSITO_CAJERO'),
(920.30, 9, '2025-03-28 20:45:00', 39, 'DEPOSITO_OTRA_CUENTA'),
(650.90, 10, '2025-03-28 21:45:00', 40, 'COMPRA_ESTABLECIMIENTO');