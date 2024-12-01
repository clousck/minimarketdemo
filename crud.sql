CREATE TABLE videogame(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    developer_name VARCHAR(255) NOT NULL,
    category_id integer NOT NULL,
    publication_year integer NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE category(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL
);

-- Inserciones para la tabla "category"
INSERT INTO category (name, description) VALUES 
('Action', 'Games focused on physical challenges, including hand-eye coordination and reaction time.'),
('Adventure', 'Games that emphasize story-driven exploration and puzzle-solving.'),
('RPG', 'Role-playing games where players assume the roles of characters in a fictional setting.'),
('Simulation', 'Games that replicate real-world activities, such as life simulation or construction.'),
('Sports', 'Games that simulate playing various sports.');

-- Inserciones para la tabla "videogame"
INSERT INTO videogame (name, developer_name, category_id, publication_year) VALUES
('The Witcher 3: Wild Hunt', 'CD Projekt Red', 3, 2015),
('FIFA 23', 'EA Sports', 5, 2022),
('Minecraft', 'Mojang Studios', 4, 2011),
('Uncharted 4: A Thief\'s End', 'Naughty Dog', 2, 2016),
('Call of Duty: Modern Warfare II', 'Infinity Ward', 1, 2022);