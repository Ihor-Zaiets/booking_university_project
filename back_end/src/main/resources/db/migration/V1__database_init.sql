CREATE TYPE public.reservation_status AS ENUM (
    'ACTIVE',
    'WAITING',
    'REVOKED',
    'FINISHED',
    'UNFINISHED');

CREATE CAST (character varying AS public.reservation_status) WITH INOUT AS IMPLICIT;

CREATE TABLE public.apartment (
                                  id serial primary key ,
                                  number_of_rooms integer NOT NULL,
                                  square numeric(10,2),
                                  rent_price numeric(10,2) NOT NULL,
                                  floor integer,
                                  description text,
                                  number_of_double_beds integer NOT NULL,
                                  number_of_single_beds integer NOT NULL
);

CREATE TABLE public."user" (
                               id serial primary key ,
                               first_name text NOT NULL,
                               surname text,
                               email text,
                               phone text NOT NULL,
                               address text
);

CREATE TABLE public.reservation (
                                    id serial primary key ,
                                    apartment_id integer NOT NULL,
                                    user_id integer NOT NULL,
                                    start_date timestamp without time zone NOT NULL,
                                    end_date timestamp without time zone NOT NULL,
                                    number_of_people integer NOT NULL,
                                    reservation_status public.reservation_status NOT NULL,
                                    price numeric(10,2) NOT NULL
);