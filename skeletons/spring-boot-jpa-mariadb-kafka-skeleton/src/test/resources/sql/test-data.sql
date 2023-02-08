delete from customer_order_ordered_item;
delete from customer_order;
delete from ordered_item;
delete from payment_details;
delete from shipping_details;
delete from customer;


insert into customer (id, version, email, first_name, last_name, password, username, created_by, created_date)
values  (1, 0, 'ivangsa@gmail.com', 'name', 'surname', 'pass', 'user', 'system', current_timestamp);

insert into payment_details (id, version, card_holder_name, credit_card_number, customer_id)
values (1, 0, 'name', '0000000000000000', 1);

insert into shipping_details (id, version, address, customer_id, phone)
values (1, 0, '13 Rue del Percebe', 1, '555 5555 555');

insert into customer_order (id, version, customer_id, date, payment_details_id, shipping_details_address, shipping_details_phone, status)
values (1, 0, 1, '2017-01-01', 1, '13 Rue del Percebe', '555 555 555', 'CONFIRMED');
