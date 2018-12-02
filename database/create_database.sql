--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.11
-- Dumped by pg_dump version 9.6.11

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: maze; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE maze WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';


ALTER DATABASE maze OWNER TO postgres;

\connect maze

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: maze; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.maze (
    id_maze bigint NOT NULL,
    begin_x integer NOT NULL,
    begin_y integer NOT NULL,
    end_x integer NOT NULL,
    end_y integer NOT NULL,
    height integer NOT NULL,
    name character varying(255) NOT NULL,
    width integer NOT NULL
);


ALTER TABLE public.maze OWNER TO postgres;

--
-- Name: point; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.point (
    id_point bigint NOT NULL,
    point_x integer NOT NULL,
    point_y integer NOT NULL,
    id_maze bigint NOT NULL
);


ALTER TABLE public.point OWNER TO postgres;

--
-- Name: maze maze_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.maze
    ADD CONSTRAINT maze_pkey PRIMARY KEY (id_maze);


--
-- Name: point point_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.point
    ADD CONSTRAINT point_pkey PRIMARY KEY (id_point);


--
-- Name: point ukrel0rhr69rvks6900eek4xfcu; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.point
    ADD CONSTRAINT ukrel0rhr69rvks6900eek4xfcu UNIQUE (point_x, point_y, id_maze);


--
-- Name: point fkdbfel6kv2w7rfvh7e9xv5mb3r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.point
    ADD CONSTRAINT fkdbfel6kv2w7rfvh7e9xv5mb3r FOREIGN KEY (id_maze) REFERENCES public.maze(id_maze);


--
-- PostgreSQL database dump complete
--

