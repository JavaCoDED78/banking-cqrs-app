CREATE TABLE IF NOT EXISTS accounts
(
    id      VARCHAR(36) PRIMARY KEY,
    number  VARCHAR NOT NULL UNIQUE,
    balance NUMERIC NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS clients
(
    id         VARCHAR(36) PRIMARY KEY,
    name       VARCHAR     NOT NULL,
    account_id varchar(36) NOT NULL,
    CONSTRAINT clients_accounts FOREIGN KEY (account_id) REFERENCES accounts (id) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS cards
(
    id         VARCHAR(36) PRIMARY KEY,
    number     VARCHAR(16) NOT NULL,
    date       VARCHAR(5)  NOT NULL,
    cvv        VARCHAR(3)  NOT NULL,
    account_id VARCHAR(36) NOT NULL,
    CONSTRAINT cards_unique UNIQUE (number, date),
    CONSTRAINT cards_accounts FOREIGN KEY (account_id) REFERENCES accounts (id) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS client_cards
(
    client_id VARCHAR(36) NOT NULL,
    card_id   VARCHAR(36) NOT NULL,
    CONSTRAINT client_cards_unique UNIQUE (client_id, card_id),
    CONSTRAINT client_cards_clients FOREIGN KEY (client_id) REFERENCES clients (id) ON DELETE CASCADE ON UPDATE NO ACTION,
    CONSTRAINT client_cards_cards FOREIGN KEY (card_id) REFERENCES cards (id) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS transactions
(
    id      VARCHAR(36) PRIMARY KEY,
    from_id VARCHAR(36) NOT NULL,
    to_id   VARCHAR(36) NOT NULL,
    CONSTRAINT transactions_cards_from FOREIGN KEY (from_id) REFERENCES cards (id) ON DELETE CASCADE ON UPDATE NO ACTION,
    CONSTRAINT transactions_cards_to FOREIGN KEY (to_id) REFERENCES cards (id) ON DELETE CASCADE ON UPDATE NO ACTION
);