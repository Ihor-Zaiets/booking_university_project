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
                                  id integer DEFAULT nextval('public.user_id_seq'::regclass) NOT NULL,
                                  number_of_rooms integer NOT NULL,
                                  square numeric(10,2),
                                  rent_price numeric(10,2) NOT NULL,
                                  floor integer,
                                  description text,
                                  number_of_double_beds integer NOT NULL,
                                  number_of_single_beds integer NOT NULL
);

CREATE TABLE public."user" (
                               id integer NOT NULL,
                               name text NOT NULL,
                               surname text,
                               email text,
                               phone text NOT NULL,
                               address text
);

CREATE TABLE public.reservation (
                                    id integer NOT NULL,
                                    apartment_id integer NOT NULL,
                                    user_id integer NOT NULL,
                                    start_datetime timestamp without time zone NOT NULL,
                                    end_datetime timestamp without time zone NOT NULL,
                                    number_of_people integer NOT NULL,
                                    status public.reservation_status NOT NULL,
                                    price numeric(10,2) NOT NULL
);