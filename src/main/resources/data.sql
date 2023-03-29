INSERT INTO "PUBLIC"."PLANT" VALUES

                                 (1, '7', 'Ficus lyrata', 'plant-1.jpg', 'Fiddle-leaf fig'),
                                 (2, '6', 'Phyllostachys aurea', 'plant-2.jpg', 'Golden Bamboo'),
                                 (3, '2', 'Sansevieria trifasciata', 'plant-3.jpg', 'Snake Plant');

INSERT INTO "PUBLIC"."ARTIKEL" VALUES
    (1, 'Decor', 'The Perfect Trio of Houseplants: Fiddle-leaf Fig, Golden Bamboo, and Snake Plant');

INSERT INTO ARTIKEL_PLANTS (ARTIKELS_ID, PLANTS_ID) VALUES (1, 1);
INSERT INTO ARTIKEL_PLANTS (ARTIKELS_ID, PLANTS_ID) VALUES (1, 2);
INSERT INTO ARTIKEL_PLANTS (ARTIKELS_ID, PLANTS_ID) VALUES (1, 3);