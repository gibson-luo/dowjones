
-- Sequence and defined type
CREATE SEQUENCE IF NOT EXISTS reference_id_seq;

-- Table Definition
CREATE TABLE "reference" (
    "id" int8 NOT NULL DEFAULT nextval('reference_id_seq'::regclass),
    "quarter" int4 NOT NULL,
    "stock" varchar NOT NULL,
    "date" varchar NOT NULL,
    "open" varchar,
    "high" varchar,
    "low" varchar,
    "close" varchar,
    "volume" varchar,
    "percent_change_price" varchar,
    "percent_change_volume_over_last_wk" varchar,
    "previous_weeks_volume" varchar,
    "next_weeks_open" varchar,
    "next_weeks_close" varchar,
    "percent_change_next_weeks_price" varchar,
    "days_to_next_dividend" int4,
    "percent_return_next_dividend" varchar,
    PRIMARY KEY ("id")
);

CREATE UNIQUE INDEX ON "reference" ("stock", "date");