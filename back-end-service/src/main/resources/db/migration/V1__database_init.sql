CREATE TYPE public.reservation_status AS ENUM (
    'ACTIVE',
    'WAITING',
    'REVOKED',
    'FINISHED',
    'UNFINISHED');

CREATE CAST (character varying AS public.reservation_status) WITH INOUT AS IMPLICIT;

CREATE TABLE public.apartment (
                                  id serial primary key,
                                  number_of_rooms integer NOT NULL,
                                  square numeric(10,2),
                                  rent_price numeric(10,2) NOT NULL,
                                  floor integer,
                                  description text,
                                  number_of_double_beds integer NOT NULL,
                                  number_of_single_beds integer NOT NULL,
                                  address text NOT NULL
);

CREATE TABLE public."user" (
                               id serial primary key,
                               login text,
                               password text,
                               firstname text NOT NULL,
                               surname text,
                               email text,
                               phone text NOT NULL,
                               address text,
                               CONSTRAINT user__login_uk UNIQUE (login)
);

CREATE TABLE public.reservation (
                                    id serial primary key ,
                                    apartment_id integer NOT NULL,
                                    user_id integer NOT NULL,
                                    start_date timestamp without time zone NOT NULL,
                                    end_date timestamp without time zone NOT NULL,
                                    number_of_people integer NOT NULL,
                                    reservation_status public.reservation_status NOT NULL,
                                    price numeric(10,2) NOT NULL,
                                    FOREIGN KEY (apartment_id) REFERENCES public.apartment (id),
                                    FOREIGN KEY (user_id) REFERENCES public."user" (id)
);

CREATE TABLE public."role" (
                               id serial primary key,
                               "name" text NOT NULL,
                               description varchar NULL
);

CREATE TABLE public.user_role (
                                  id serial primary key,
                                  user_id int NOT NULL,
                                  role_id int NOT NULL,
                                  CONSTRAINT user_role_un UNIQUE (user_id,role_id),
                                  CONSTRAINT user_role_fk FOREIGN KEY (user_id) REFERENCES public."user"(id) ON DELETE CASCADE,
                                  CONSTRAINT user_role_fk_1 FOREIGN KEY (role_id) REFERENCES public."role"(id) ON DELETE CASCADE
);
