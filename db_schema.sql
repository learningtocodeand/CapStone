create database money_transfer;

use money_transfer;

CREATE TABLE accounts (
         account_id VARCHAR(50) PRIMARY KEY,
         balance DECIMAL(15, 2) NOT NULL,
         status VARCHAR(20) NOT NULL
     );

CREATE TABLE `transactions` (
         transaction_id VARCHAR(50) PRIMARY KEY,
         from_account VARCHAR(50) NOT NULL,
         to_account VARCHAR(50) NOT NULL,
         amount DECIMAL(15, 2) NOT NULL,
         status VARCHAR(20) NOT NULL,
         created_at DATETIME NOT NULL
     );

ALTER TABLE `transactions`
     ADD CONSTRAINT fk_from_account
     FOREIGN KEY (from_account)
     REFERENCES accounts(account_id);

ALTER TABLE `transactions`
     ADD CONSTRAINT fk_to_account
     FOREIGN KEY (to_account)
     REFERENCES accounts(account_id);