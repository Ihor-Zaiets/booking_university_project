CREATE TYPE public.reservation_status AS ENUM (
    'ACTIVE',
    'WAITING',
    'REVOKED',
    'FINISHED',
    'UNFINISHED');

CREATE SEQUENCE public.reservation_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
    CACHE 1
    NO CYCLE;

CREATE SEQUENCE public.user_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
    CACHE 1
    NO CYCLE;

CREATE TABLE public.apartment (
                                  id int4 NOT NULL DEFAULT nextval('user_id_seq'::regclass),
                                  number_of_rooms int4 NOT NULL,
                                  square numeric(10, 2) NULL,
                                  rent_price numeric(10, 2) NOT NULL,
                                  floor int4 NULL,
                                  description text NULL,
                                  max_users int4 NULL,
                                  double_bed bool NOT NULL DEFAULT false,
                                  single_bed bool NOT NULL DEFAULT false,
                                  CONSTRAINT apartment_pk PRIMARY KEY (id)
);

CREATE TABLE public."user" (
                               id serial4 NOT NULL,
                               "name" text NOT NULL,
                               surname text NULL,
                               email text NULL,
                               phone text NOT NULL,
                               address text NULL,
                               CONSTRAINT user_pkey PRIMARY KEY (id)
);

CREATE TABLE public.reservation (
                                    id serial4 NOT NULL,
                                    apartment_id int4 NOT NULL,
                                    user_id int4 NOT NULL,
                                    start_datetime timestamp NOT NULL,
                                    end_datetime timestamp NOT NULL,
                                    number_of_people int4 NOT NULL,
                                    status public.reservation_status NOT NULL,
                                    price numeric(10, 2) NULL,
                                    CONSTRAINT reservation_pkey PRIMARY KEY (id),
                                    CONSTRAINT reservation_apartment_id_fkey FOREIGN KEY (apartment_id) REFERENCES public.apartment(id),
                                    CONSTRAINT reservation_user_id_fkey FOREIGN KEY (user_id) REFERENCES public."user"(id)
);