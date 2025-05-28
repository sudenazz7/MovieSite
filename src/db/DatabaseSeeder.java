package db;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import db.DatabaseConfig;

public class DatabaseSeeder {
    /*public static void main(String[] args) {
        DatabaseSeeder seeder = new DatabaseSeeder();
        seeder.seedDatabase();
    }
    public static void seedDatabase() {
        try (Connection conn = DatabaseConfig.connect();
             Statement stmt = conn.createStatement()) {

            // Directors
            stmt.executeUpdate("""
    INSERT INTO directors (name, birthdate) VALUES
        ('Filip Zylber', '1960-02-15'),
        ('Ketche Hakan Kırvavaç', '1973-01-01'),
        ('Emre Kabakuşak', '1982-03-08'),
        ('Gönenç Uyanık', '1980-10-05'),
        ('Erdem Tepegöz', '1982-04-11'),
        ('Rawson Marshall Thurber', '1975-11-09'),
        ('Sam Hargrave', '1983-01-28'),
        ('James Wan', '1977-02-26'),
        ('Wes Ball', '1980-10-20'),
        ('Louis Leterrier', '1973-06-17'),
        ('Justin Dec', '1982-05-16'),
        ('Susanne Bier', '1960-04-15'),
        ('Peter Thorwarth', '1971-07-03'),
        ('Paween Purijitpanya', '1978-12-12'),
        ('Alexandre Aja', '1978-08-07'),
        ('Bedran Güzel', '1979-06-21'),
        ('Togan Gökbakar', '1984-05-16'),
        ('Doğa Can Anafarta', '1987-12-15'),
        ('Robert Rodriguez', '1968-06-20'),
        ('Keenen Ivory Wayans', '1958-06-08'),
        ('Grant Sputore', '1985-09-04'),
        ('Oriol Paulo', '1975-07-12'),
        ('Boris Kunz', '1979-01-01'),
        ('M. Night Shyamalan', '1970-08-06'),
        ('Ben Young', '1982-01-01'),
        ('Tom McGrath', '1964-06-05'),
        ('Eric Darnell', '1961-08-21'),
        ('Mike Mitchell', '1970-10-18'),
        ('Robert Cullen', '1977-03-23'),
        ('José Luis Ucha', '1973-11-11'),
        ('Conrad Helten', '1970-04-09'),
        ('George Kay', '1891-09-21'),
        ('Frank Árpád Darabont', '1959-01-28'),
        ('Chris Brancato', '1962-07-24'),
        ('Carlo Bernard', '1909-10-13'),
        ('Doug Miro', '1972-01-20'),
        ('Umut Aral', '1976-03-18'),
        ('Can Evrenol', '1982-01-01'),
        ('Burcu Alptekin', '1982-10-06'),
        ('Gökhan Tiryaki', '1972-01-01'),
        ('Alex Pina', '1967-06-23'),
        ('The Duffer Brothers', '1984-02-15'),
        ('Sydney Pollack', '1934-07-01'),
        ('Yeon Sang-ho', '1978-10-25'),
        ('Choi Gyu-seok', '1977-10-10'),
        ('Ryu Yong-jae', '1980-12-04'),
        ('Neil LaBute', '1963-03-19'),
        ('Müge Turalı', '1985-05-09'),
        ('Darren Star', '1961-07-25'),
        ('David Crane', '1957-08-13'),
        ('Marta Kauffman', '1956-09-21'),
        ('Pamela Fryman', '1959-08-19'),
        ('Jenji Kohan', '1969-07-05'),
        ('Bertan Başaran', '1983-11-14'),
        ('Chris Van Dusen', '1960-03-17'),
        ('Nicole Taylor', '1978-06-02'),
        ('Umur Turagay', '1969-01-03'),
        ('Sarah Lampert', '1991-09-11'),
        ('Neil Gaiman', '1960-11-10'),
        ('Lauren Schmidt Hissrich', '1978-08-01'),
        ('Steven Maeda', '1972-12-14'),
        ('Matt Owens', '1984-05-03'),
        ('Alfred Gough', '1967-08-22'),
        ('Miles Millar', '1967-12-17'),
        ('Mark Romanek', '1959-09-18'),
        ('Vincent Waller', '1960-11-30'),
        ('Thomas Astruc', '1975-06-18'),
        ('Duncan Rouleau', '1966-04-22'),
        ('Joe Casey', '1977-11-02'),
        ('Joe Kelly', '1971-03-01'),
        ('Steven T. Seagle', '1965-08-16'),
        ('Pendleton Ward', '1982-07-08'),
        ('Iginio Straffi', '1965-05-30');
""");

            //USERS FAVOURITES
            stmt.executeUpdate("INSERT INTO users_favourites (title, description, release_date, duration, rating, age_limit, director_id, type) VALUES " +
                    "('Heart Parade', 'A woman from a big city unexpectedly finds love during a trip to a small town.', '2022-02-14', 108, 6.4, 18, 1, 'Movie')," +
                    "('Love Tactics', 'A fashion blogger and an ad executive both play games of love, but unexpected emotions arise.', '2022-02-11', 103, 6.1, 13, 2, 'Movie')," +
                    "('Thank You Next', 'A modern romantic drama about love, breakups, and rediscovery.', '2023-01-10', 160, 6.5, 16, 3, 'Series')," +
                    "('One Day', 'Two people revisit their relationship each year on the same day.', '2024-02-14', 200, 7.9, 18, 4, 'Series')," +
                    "('Lupin', 'A gentleman thief inspired by Arsène Lupin sets out to avenge his father.', '2021-01-08', 780, 7.5, 16, 5, 'Series')," +
                    "('The Maze Runner', 'A teen awakens in a maze with no memory and must find a way out.', '2014-09-19', 114, 6.8, 16, 6, 'Movie')," +
                    "('La Casa De Papel', 'A criminal mastermind plans the biggest heist in history.', '2017-05-02', 4800, 8.2, 18, 7, 'Series')," +
                    "('Bird Box', 'In a world terrorized by unseen forces, a mother and her children seek sanctuary.', '2018-12-21', 124, 6.6, 18, 8, 'Movie')," +
                    "('Stranger Things', 'Strange events unfold in a small town involving supernatural forces and secret experiments.', '2016-07-15', 2720, 8.7, 16, 9, 'Series')," +
                    "('Van Helsing', 'Vanessa Helsing must battle vampires to save humanity.', '2016-09-23', 6500, 6.2, 18, 10, 'Series')," +
                    "('Little Man', 'A small criminal masquerades as a baby to steal a diamond.', '2006-07-14', 97, 4.4, 16, 11, 'Movie')," +
                    "('Friends', 'Six friends navigate life and love in New York City.', '1994-09-22', 47200, 8.9, 13, 12, 'Series')," +
                    "('Orange is The New Black', 'A woman’s prison sentence changes her life in unexpected ways.', '2013-07-11', 12740, 8.0, 16, 13, 'Series')," +
                    "('I Am Mother', 'A teen raised by a robot discovers disturbing truths about the outside world.', '2019-06-07', 113, 6.7, 13, 14, 'Movie')," +
                    "('Paradise', 'A futuristic thriller about time as currency and the consequences of trading it.', '2023-07-27', 118, 6.4, 18, 15, 'Movie')," +
                    "('The Witcher', 'A monster hunter struggles to find his place in a world where people often prove more wicked than beasts.', '2019-12-20', 1440, 8.1, 18, 16, 'Series')," +
                    "('Wednesday', 'Wednesday Addams investigates mysteries at Nevermore Academy.', '2022-11-23', 160, 8.3, 18, 17, 'Series')," +
                    "('Madagascar', 'Zoo animals crash-land on an exotic island.', '2005-05-27', 86, 6.9, 7, 18, 'Movie')," +
                    "('Boss Baby', 'A suit-wearing, briefcase-carrying baby teams up with his brother to stop the dastardly plot of the CEO of Puppy Co.', '2017-03-31', 97, 6.3, 7, 19, 'Movie')," +
                    "('Adventure Time', 'A boy and his magical dog go on surreal adventures in the Land of Ooo.', '2010-04-05', 56600, 8.6, 7, 20, 'Series');");

            //POPULAR THIS WEEK
            stmt.execute("""
INSERT INTO popular_this_week (pop_id, title, description, release_date, duration, rating, age_limit, director_id, type)
VALUES
(1, 'Ölümlü Dünya 2', 'Zafer’in Örgüt’e düşmesiyle, Mermer suikastçi klanının ortaya çıkışı.', '2023-12-01', 115, 8.2, 16, 1, 'movie'),
(2, 'Honeymoonish', 'Hızlı evlenme planı yapan çifti anlatan, birbirlerini yeni tanıyan insanların yaşadığı sürprizler.', '2024-05-10', 100, 6.7, 13, 2, 'movie'),
(3, 'Minions-2: Rise of Gru', 'Süper kötü idolü tarafından reddedilen küçük Gru''nun, beceriksiz minyonlarıyla macerası.', '2022-07-01', 87, 7.5, 7, 3, 'movie'),
(4, 'Barbarian', 'Korku dolu evde yaşanan gizemli ve ürkütücü olaylar.', '2022-09-10', 103, 7.1, 18, 4, 'movie'),
(5, 'Secrets of Neanderthals', 'Neandertallerin hayatını ve gizemli kayboluşlarını araştıran belgesel.', '2024-04-22', 80, 7.9, 10, 5, 'movie'),
(6, 'Fantastic Monsters: Secrets of Dumbledore', 'Sihirli dünyada kötü güçlere karşı verilen mücadele.', '2022-04-15', 142, 7.2, 12, 6, 'movie'),
(7, 'Unfrosted', 'Rakip kahvaltılık şirketlerin absürt rekabeti ve nostalji dolu komedi.', '2024-05-03', 96, 6.4, 10, 7, 'movie'),
(8, 'Ölümlü Dünya', 'Suikastçi aile ve restoran işletmecileri arasında geçen karmaşık ve komik olaylar.', '2018-01-26', 107, 8.0, 16, 1, 'movie'),
(9, 'Rebel Moon Part-II: The Scargiver', 'İmkansız direniş veren asi savaşçıların uzayda geçen macerası.', '2024-04-19', 123, 6.8, 15, 8, 'movie'),
(10, 'The Black Phone', 'Maskeli bir adamın kaçırdığı çocuğun, öldürülmüş kurbanların telefonları aracılığıyla yardım arayışı.', '2022-06-24', 105, 7.0, 16, 9, 'movie');
""");


            //NEW RELEASES
            stmt.executeUpdate("""
                INSERT INTO new_releases (title, description, duration, rating, age_limit, director_id, type) VALUES
                ('A Man in Full', 'Oscar ödüllü Regina King''in yürüttüğü ve yönettiği dizi, emlak mogulünün hayatını konu alıyor.', 6, 8.2, 16, 1, 'series'),
                ('Minions The Rise Of Gru', 'Ödüllü seslendirme kadrosuyla süper kötü karakterin köken hikayesi.', 87, 7.1, 7, 2, 'movie'),
                ('Ölümlü Dünya 2', 'Zafer’in Örgüt’e düşmesiyle, Mermer suikastçi klanının ortaya çıkışı.', 115, 8.4, 13, 3, 'movie'),
                ('Dead Boy Detectiues', 'İki hayalet genç ve bir kahin gizemleri çözüyor, güçlü bir cadı işleri karıştırıyor.', 8, 7.7, 16, 4, 'series'),
                ('Love, Divided', 'Piyanist Valentina yeni başlangıçta, komşusu David ise gürültüden nefret eden bir mucit.', 98, 6.9, 13, 5, 'movie'),
                ('Thank You, Next', 'Boşanma davası olan avukat Leyla''nın hikayesi, Feyyaz adlı aşçıyla tanışması.', 8, 7.3, 15, 6, 'series'),
                ('As The Crow Flies', 'Gazeteci Lale Kıran’a hayran Aslı''nın staj mücadelesi.', 8, 7.8, 13, 7, 'series'),
                ('Parasyte The Grey', 'Dünya’ya inen parazitler, enfekte edemediği kadınla iş birliği yapıyor.', 6, 8.0, 18, 8, 'series'),
                ('Barbarian', 'Detroit’de genç kadın kiralık evde korkunç sürprizlerle karşılaşıyor.', 103, 7.0, 18, 9, 'movie'),
                ('The Final: Attack On Wembley', '2021 Euro finali ve sonrasında yaşanan büyük felaketin hikayesi.', 82, 6.5, 10, 10, 'movie');
        """);

            //ACTORS
            stmt.executeUpdate("""
                INSERT INTO actors (name, birthdate) VALUES
                ('Omar Sy', '1978-01-20'),
                ('Ludivine Sagnier', '1979-07-03'),
                ('Clotilde Hesme', '1979-02-03'),
                ('Nicole Garcia', '1946-04-22'),
                ('Hervé Pierre', '1955-04-23'),
                ('Soufiane Guerrab', '1987-01-13'),
                ('Antoine Gouy', '1980-03-21'),
                ('Fargass Assandé', '1978-07-03'),
                ('Vincent Londez', '1978-07-03'),
                ('Shirine Boutella', '1990-08-22'),
                ('Mamadou Haidara', '1978-07-03'),
                ('Etan Simon', '1978-07-03'),
                ('Ludmilla Makowski', '1978-07-03'),
                ('Andrew Lincoln', '1973-09-14'),
                ('Steven Yeun', '1983-12-21'),
                ('Norman Reedus', '1969-01-06'),
                ('Chandler Riggs', '1999-06-27'),
                ('Melissa McBride', '1965-05-23'),
                ('Lauren Cohan', '1982-01-07'),
                ('Danai Gurira', '1978-02-14'),
                ('Wagner Moura', '1976-06-27'),
                ('Pedro Pascal', '1975-04-02'),
                ('Boyd Holbrook', '1981-09-01'),
                ('Damién Alcazar', '1963-01-08'),
                ('Alberto Ammann', '1978-10-20'),
                ('Francisco Denis', '1968-05-18'),
                ('Pepé Rapazote', '1967-09-10'),
                ('Matias Varela', '1980-07-22'),
                ('Çağatay Ulusoy', '1990-09-23'),
                ('Ayça Ayşin Turan', '1992-10-25'),
                ('Hazar Ergüçlü', '1993-01-01'),
                ('Okan Yalabık', '1978-12-13'),
                ('Funda Eryiğit', '1984-11-06'),
                ('Mehmet Kurtuluş', '1972-04-27'),
                ('Engin Öztürk', '1986-09-28'),
                ('Bige Önal', '1990-02-01'),
                ('İlayda Alişan', '1996-02-26'),
                ('Úrsula Corberó', '1989-08-11'),
                ('Álvaro Morte', '1975-02-23'),
                ('Itziar Ituño', '1974-06-18'),
                ('Pedro Alonso', '1971-06-21'),
                ('Miguel Herrán', '1996-04-25'),
                ('Jaime Lorente', '1991-12-12'),
                ('Esther Acebo', '1983-01-19'),
                ('Darko Perić', '1977-03-25'),
                ('Hovik Keuchkerian', '1972-11-14'),
                ('Luka Peroš', '1976-10-28'),
                ('Winona Ryder', '1971-10-29'),
                ('David Harbour', '1975-04-10'),
                ('Millie Bobby Brown', '2004-02-19'),
                ('Finn Wolfhard', '2002-12-23'),
                ('Gaten Matarazzo', '2002-09-08'),
                ('Caleb McLaughlin', '2001-10-13'),
                ('Noah Schnapp', '2004-10-03'),
                ('Sadie Sink', '2002-04-16'),
                ('Natalia Dyer', '1995-01-13'),
                ('Charlie Heaton', '1994-02-06'),
                ('Kiernan Shipka', '1999-11-10'),
                ('Ross Lynch', '1995-12-29'),
                ('Miranda Otto', '1967-12-16'),
                ('Lucy Davis', '1973-02-17'),
                ('Chance Perdomo', '1996-10-19'),
                ('Michelle Gomez', '1966-11-23'),
                ('Jaz Sinclair', '1994-07-24'),
                ('Lachlan Watson', '2001-04-12'),
                ('Gavin Leatherwood', '1994-06-07'),
                ('Tati Gabrielle', '1996-01-25'),
                ('Adeline Rudolph', '1995-02-10'),
                ('Richard Coyle', '1972-02-27'),
                ('Abigail Cowen', '1998-03-18'),
                ('Yoo Ah-in', '1986-10-06'),
                ('Kim Hyun-joo', '1977-04-24'),
                ('Park Jeong-min', '1987-02-25'),
                ('Won Jin-a', '1991-03-29'),
                ('Yang Ik-june', '1975-12-19'),
                ('Kim Do-yoon', '1980-08-07'),
                ('Kim Shin-rock', '1981-03-23'),
                ('Ryu Kyung-soo', '1992-10-12'),
                ('Lee Re', '2006-03-12'),
                ('Jeon So-nee', '1991-03-21'),
                ('Koo Kyo-hwan', '1982-12-14'),
                ('Lee Jung-hyun', '1980-02-07'),
                ('Kwon Hae-hyo', '1965-08-13'),
                ('Kim In-kwon', '1978-01-29'),
                ('Kelly Overton', '1978-08-28'),
                ('Jonathan Scarfe', '1975-12-16'),
                ('Christopher Heyerdahl', '1963-09-18'),
                ('Missy Peregrym', '1982-06-16'),
                ('Paul Johansson', '1964-01-26'),
                ('Rukiya Bernard', '1979-01-20'),
                ('Vincent Gale', '1968-03-06'),
                ('Aleks Paunovic', '1969-06-29'),
                ('Trezzo Mahoro', '1978-07-03'),
                ('Demet Evgar', '1980-05-18'),
                ('Emre Karayel', '1972-01-01'),
                ('Lily Collins', '1989-03-18'),
                ('Philippine Leroy-Beaulieu', '1963-04-25'),
                ('Ashley Park', '1991-06-06'),
                ('Lucas Bravo', '1988-01-26'),
                ('Kate Walsh', '1967-10-13'),
                ('Samuel Arnold', '1996-04-18'),
                ('Bruno Gouery', '1975-05-25'),
                ('Camille Razat', '1994-03-01'),
                ('Lucien Laviscount', '1992-05-09'),
                ('Paul Forman', '1994-01-16'),
                ('Melia Kreiling', '1990-10-06'),
                ('Kevin Dias', '1978-07-03'),
                ('Jennifer Aniston', '1969-02-11'),
                ('Courteney Cox', '1964-06-15'),
                ('Lisa Kudrow', '1963-07-30'),
                ('Matt LeBlanc', '1967-07-25'),
                ('Matthew Perry', '1969-08-19'),
                ('David Schwimmer', '1966-11-02'),
                ('Josh Radnor', '1974-07-29'),
                ('Cobie Smulders', '1982-04-03'),
                ('Jason Segel', '1980-01-18'),
                ('Alyson Hannigan', '1974-03-24'),
                ('Neil Patrick Harris', '1973-06-15'),
                ('Joe Manganiello', '1976-12-28'),
                ('Suzie Plakson', '1958-06-03'),
                ('Bob Saget', '1956-05-17'),
                ('Taylor Schilling', '1984-07-27'),
                ('Kate Mulgrew', '1955-04-29'),
                ('Laura Prepon', '1980-03-07'),
                ('Jason Biggs', '1978-05-12'),
                ('Natasha Lyonne', '1979-04-04'),
                ('Michael Harney', '1956-03-27'),
                ('Uzo Aduba', '1981-02-10'),
                ('Danielle Brooks', '1989-09-17'),
                ('Samira Wiley', '1987-04-15'),
                ('Dascha Polanco', '1982-12-03'),
                ('Selenis Leyva', '1972-05-26'),
                ('Nick Sandow', '1966-08-03'),
                ('Yael Stone', '1985-03-06'),
                ('Taryn Manning', '1978-11-06'),
                ('Lea DeLaria', '1958-05-23'),
                ('Serenay Sarıkaya', '1991-07-01'),
                ('Metin Akdülger', '1988-04-10'),
                ('Hakan Kurtaş', '1988-09-07'),
                ('Boran Kuzum', '1992-05-09'),
                ('Ahmet Rıfat Şungar', '1983-03-17'),
                ('Bade İşçil', '1983-08-08'),
                ('Esra Rusan', '1983-10-21'),
                ('Meriç Aral', '1988-11-17'),
                ('Efe Tunçer', '1990-01-01'),
                ('Kamil Güler', '1980-10-29'),
                ('Cem Güler', '1978-07-03'),
                ('Adjoa Andoh', '1963-01-14'),
                ('Julie Andrews', '1935-10-01'),
                ('Lorraine Ashbourne', '1960-09-07'),
                ('Jonathan Bailey', '1988-04-25'),
                ('Ruby Barker', '1996-12-23'),
                ('Sabrina Bartlett', '1991-01-01'),
                ('Harriet Cains', '1993-01-01'),
                ('Bessie Carter', '1993-10-28'),
                ('Nicola Coughlan', '1987-01-09'),
                ('Phoebe Dynevor', '1995-04-17'),
                ('Ambika Mod', '1995-10-18'),
                ('Leo Woodall', '1996-04-21'),
                ('Essie Davis', '1970-01-19'),
                ('Tim McInnerny', '1956-09-18'),
                ('Amber Grappy', '1978-07-03'),
                ('Jonny Weldon', '1978-07-03'),
                ('Eleanor Tomlinson', '1992-05-19'),
                ('Brendan Quinn', '1978-07-03'),
                ('Burak Deniz', '1991-02-17'),
                ('Mustafa Uğurlu', '1955-10-25'),
                ('Mahir Günşiray', '1960-08-10'),
                ('Ebru Özkan', '1978-11-18'),
                ('Mert Ramazan Demir', '1998-01-28'),
                ('Hakan Karahan', '1978-07-03'),
                ('Elif Nur Kerkük', '1978-07-03'),
                ('Mehmet Bilge Aslan', '1978-07-03'),
                ('Brianne Howey', '1989-05-24'),
                ('Antonia Gentry', '1997-09-25'),
                ('Diesel La Torraca', '1978-07-03'),
                ('Jennifer Robertson', '1971-11-24'),
                ('Felix Mallard', '1998-04-20'),
                ('Sara Waisglass', '1998-07-03'),
                ('Scott Porter', '1979-07-14'),
                ('Raymond Ablack', '1989-11-12'),
                ('Aaron Ashmore', '1979-04-04'),
                ('Nathan Mitchell', '1988-12-06'),
                ('Tom Ellis', '1978-11-17'),
                ('Lauren German', '1978-11-29'),
                ('Kevin Alejandro', '1976-04-07'),
                ('D.B. Woodside', '1969-07-25'),
                ('Lesley-Ann Brandt', '1981-12-02'),
                ('Aimee Garcia', '1978-11-28'),
                ('Scarlett Estevez', '2007-12-04'),
                ('Rachael Harris', '1968-01-12'),
                ('Inbar Lavi', '1986-10-27'),
                ('Tricia Helfer', '1974-04-11'),
                ('Tom Welling', '1977-04-26'),
                ('Jeremiah W. Birkett', '1978-07-03'),
                ('Pej Vahdat', '1982-04-10'),
                ('Michael Gladis', '1977-08-30'),
                ('Dennis Haysbert', '1954-06-02'),
                ('Brianna Hildebrand', '1996-08-14'),
                ('Henry Cavill', '1983-05-05'),
                ('Anya Chalotra', '1996-03-21'),
                ('Freya Allan', '2001-09-06'),
                ('Joey Batey', '1989-01-28'),
                ('Eamon Farren', '1985-05-19'),
                ('MyAnna Buring', '1979-09-22'),
                ('Mimi M Khayisa', '1997-01-01'),
                ('Mahesh Jadu', '1982-10-26'),
                ('Anna Shaffer', '1992-03-10'),
                ('Royce Pierreson', '1989-01-01'),
                ('Tom Canton', '1978-07-03'),
                ('Iñaki Godoy', '2003-08-25'),
                ('Emily Rudd', '1993-02-24'),
                ('Mackenyu', '1996-11-16'),
                ('Jacob Romero Gibson', '1996-07-11'),
                ('Taz Skylar', '1995-12-05'),
                ('Vincent Regan', '1965-05-16'),
                ('Jeff Ward', '1986-12-30'),
                ('Morgan Davies', '2002-11-27'),
                ('Jenna Ortega', '2002-09-27'),
                ('Gwendoline Christie', '1978-10-27'),
                ('Riki Lindhome', '1979-03-05'),
                ('Christina Ricci', '1980-02-12'),
                ('Jamie McShane', '1978-07-03'),
                ('Hunter Doohan', '1994-01-19'),
                ('Percy Hynes White', '2001-10-08'),
                ('Emma Myers', '2002-04-02'),
                ('Joy Sunday', '1978-07-03'),
                ('Darby Stanchfield', '1971-04-29'),
                ('Connor Jessup', '1994-06-23'),
                ('Emilia Jones', '2002-02-23'),
                ('Jackson Robert Scott', '2008-09-18'),
                ('Petrice Jones', '1997-07-10'),
                ('Laysla De Oliveira', '1992-01-11'),
                ('Griffin Gluck', '2000-08-24'),
                ('Tom Kenny', '1962-07-13'),
                ('Rodger Bumpass', '1951-05-06'),
                ('Bill Fagerbakke', '1957-10-04'),
                ('Clancy Brown', '1959-01-05'),
                ('Dee Bradley Baker', '1962-08-31'),
                ('Mr. Lawrence', '1969-01-01'),
                ('Carolyn Lawrence', '1967-02-13'),
                ('Sirena Irwin', '1978-07-03'),
                ('Marcelo Pissardini', '1965-09-21'),
                ('Wendel Bezerra', '1974-05-18'),
                ('Luis PérezPons', '1951-10-16'),
                ('Cristina Valenzuela', '1987-07-11'),
                ('Bryce Papenbrook', '1986-02-21'),
                ('Keith Silverstein', '1970-12-24'),
                ('Mela Lee', '1976-07-31'),
                ('Max Mittelman', '1990-09-05'),
                ('Barbara Harris', '1935-07-25'),
                ('Tara Strong', '1973-02-12'),
                ('Paul Eiding', '1957-01-24'),
                ('Meagan Smith', '1989-06-18'),
                ('Jim Ward', '1959-05-19'),
                ('Steve Blum', '1960-04-29'),
                ('Richard McGonagle', '1946-10-22'),
                ('Fred Tatasciore', '1967-06-15'),
                ('Jeremy Shada', '1997-01-21'),
                ('John DiMaggio', '1968-09-04'),
                ('Hynden Walch', '1971-02-01'),
                ('Niki Yang', '1985-06-08'),
                ('Maria Bamford', '1970-02-25'),
                ('Steve Little', '1965-06-26'),
                ('Olivia Olson', '1992-05-21'),
                ('Haven Paschall', '1978-07-03'),
                ('Alysha Deslorieux', '1978-07-03'),
                ('Jessica Paquet', '1978-07-03'),
                ('Eileen Stevens', '1978-07-03'),
                ('Kate Bristol', '1978-07-03'),
                ('Saskia Maarleveld', '1978-07-03'),
                ('Brittany Pressley', '1978-07-03'),
                ('Billy Bob Thompson', '1978-07-03'),
                ('Anna Prochniak', '1985-12-22'),
                ('Michal Czernecki', '1978-04-04'),
                ('Iwo Rajski', '1978-07-03'),
                ('Aslı Enver', '1984-05-10'),
                ('Kaan Urgancıoğlu', '1981-05-08'),
                ('Mert Ege Ak', '1978-07-03'),
                ('Demet Özdemir', '1992-02-26'),
                ('Şükrü Özyılmaz', '1988-02-18'),
                ('Atakan Çelik', '1987-01-01'),
                ('Kıvanç Tatlıtuğ', '1983-10-27'),
                ('Beren Saat', '1984-02-26'),
                ('Alperen Duymaz', '1992-11-03'),
                ('Mehmet Günsür', '1975-05-08'),
                ('Dwayne Johnson', '1972-05-02'),
                ('Ryan Reynolds', '1976-10-23'),
                ('Gal Gadot', '1985-04-30'),
                ('Chris Hemsworth', '1983-08-11'),
                ('Rudhraksh Jaiswal', '2003-09-30'),
                ('Randeep Hooda', '1976-08-20'),
                ('Vin Diesel', '1967-07-18'),
                ('Paul Walker', '1973-09-12'),
                ('Dylan O''Brien', '1991-08-26'),
                ('Kaya Scodelario', '1992-03-13'),
                ('Thomas Brodie-Sangster', '1990-05-16'),
                ('Jesse Eisenberg', '1983-10-05'),
                ('Mark Ruffalo', '1967-11-22'),
                ('Woody Harrelson', '1961-07-23'),
                ('Jordan Calloway', '1990-10-18'),
                ('Peter Facinelli', '1973-11-26'),
                ('Tichina Arnold', '1969-06-28'),
                ('Sandra Bullock', '1964-07-26'),
                ('Trevante Rhodes', '1990-02-10'),
                ('John Malkovich', '1953-12-09'),
                ('Peri Baumeister', '1986-06-21'),
                ('Alexander Scheer', '1976-06-01'),
                ('Kais Setti', '1978-07-03'),
                ('Thanapob Leeratanakachorn', '1994-02-14'),
                ('Paris Intarakomalyasut', '1998-10-22'),
                ('Nuttanicha Dungwattanawanich', '1996-11-29'),
                ('Kiefer Sutherland', '1966-12-21'),
                ('Paula Patton', '1975-12-05'),
                ('Cameron Boyce', '1999-05-28'),
                ('Oğuzhan Koç', '1985-05-13'),
                ('İbrahim Büyükak', '1983-08-20'),
                ('Emre Kınay', '1970-03-05'),
                ('Şahan Gökbakar', '1980-10-22'),
                ('Fatma Toptaş', '1982-11-25'),
                ('Tuluğ Çizgen', '1957-05-25'),
                ('Altan Erkekli', '1955-01-20'),
                ('Toygan Avanoğlu', '1979-11-24'),
                ('Hande Katipoğlu', '1982-02-20'),
                ('YaYa Gosselin', '2009-01-24'),
                ('Priyanka Chopra Jonas', '1982-07-18'),
                ('Marlon Wayans', '1972-07-23'),
                ('Shawn Wayans', '1971-01-19'),
                ('Kerry Washington', '1977-01-31'),
                ('Clara Rugaard', '1997-01-05'),
                ('Rose Byrne', '1979-07-24'),
                ('Hilary Swank', '1974-07-30'),
                ('Adriana Ugarte', '1985-01-17'),
                ('Chino Darín', '1989-01-14'),
                ('Javier Gutiérrez', '1971-01-17'),
                ('Kostja Ullmann', '1984-05-30'),
                ('Corinna Kirchhoff', '1960-05-16'),
                ('Marlene Tanczik', '1978-07-03'),
                ('Jaden Smith', '1998-07-08'),
                ('Will Smith', '1968-09-25'),
                ('Sophie Okonedo', '1968-08-11'),
                ('Michael Peña', '1976-01-13'),
                ('Lizzy Caplan', '1982-06-30'),
                ('Israel Broussard', '1994-08-22'),
                ('Alec Baldwin', '1958-04-03'),
                ('Jimmy Kimmel', '1967-11-13'),
                ('Ben Stiller', '1965-11-30'),
                ('Chris Rock', '1965-02-07'),
                ('Jason Lee', '1970-04-25'),
                ('David Cross', '1964-04-04'),
                ('Jenny Slate', '1982-03-25'),
                ('Vanessa Hudgens', '1988-12-14'),
                ('Kimiko Glenn', '1989-06-27'),
                ('James Marsden', '1973-09-08'),
                ('Erica Lindbeck', '1992-05-29'),
                ('Shannon Chan-Kent', '1988-09-23'),
                ('Kazumi Evans', '1989-10-19');
        """);

            //  All Movies
            stmt.executeUpdate("""
    INSERT INTO movies (movie_id, title, description, release_date, duration, rating, age_limit, director_id, actors) VALUES
    (1, 'Heart Parade', 'The promotion, the engagement — she has her life all planned out. An unexpected trip to Krakow and romance.', '2022-06-15', 108, 5.7, 7, 1, 'Anna Prochniak, Michal Czernecki, Iwo Rajski'),
    (2, 'In Good Hands', 'Melisa, a single mother, is sick and has little time left. Can she find love and entrust her son?', '2022-03-15', 105, 6.5, 13, 2, 'Asli Enver, Kaan Urgancioglu, Mert Ege Ak'),
    (3, 'Love Tactics', 'She''s a blogging fashionista who doesn''t believe in love. He''s a serial dater with attachment issues.', '2022-02-11', 108, 5.9, 10, 3, 'Demet Ozdemir, Şükrü Özyılmaz, Atakan Çelik'),
    (4, 'Last Call For Istanbul', 'Beren Saat and Kıvanç Tatlıtuğ meet as married people and develop forbidden romance in NYC.', '2023-11-24', 91, 6.1, 13, 4, 'Kıvanç Tatlıtuğ, Beren Saat'),
    (5, 'Ashes', 'A wealthy woman reads an unpublished novel; fantasies turn into dangerous forbidden love.', '2023-03-10', 100, 5.6, 16, 5, 'Funda Eryiğit, Alperen Duymaz, Mehmet Günsür'),
    (6, 'Red Notice', 'FBI profiler and two art thieves team up in a globe-trotting heist.', '2021-11-12', 118, 6.3, 13, 6, 'Dwayne Johnson, Ryan Reynolds, Gal Gadot'),
    (7, 'Extraction', 'An elite soldier-for-hire rescues the kidnapped son of a drug lord.', '2020-04-24', 118, 6.8, 16, 7, 'Chris Hemsworth, Rudhraksh Jaiswal, Randeep Hooda'),
    (8, 'Fast and Furious 7', 'A street racer teams up with an unlikely ally to take down an assassin.', '2015-04-03', 137, 7.1, 13, 8, 'Vin Diesel, Paul Walker, Dwayne Johnson'),
    (9, 'The Maze Runner', 'Trapped in a maze without memory, they fight to survive.', '2014-09-19', 114, 6.8, 13, 9, 'Dylan O''Brien, Kaya Scodelario, Thomas Brodie-Sangster'),
    (10, 'Now You See Me', 'Illusionists steal from banks and outwit FBI agents.', '2013-05-31', 115, 7.2, 13, 10, 'Jesse Eisenberg, Mark Ruffalo, Woody Harrelson'),
    (11, 'Countdown', 'A nurse downloads an app predicting death and has 3 days to change fate.', '2019-10-25', 90, 5.4, 16, 11, 'Jordan Calloway, Peter Facinelli, Tichina Arnold'),
    (12, 'Bird Box', 'A mother tries to save her kids from a terrifying unseen force.', '2018-12-21', 124, 6.6, 16, 12, 'Sandra Bullock, Trevante Rhodes, John Malkovich'),
    (13, 'Blood Red Sky', 'Hijacking a plane turns deadly when a more dangerous threat appears.', '2021-07-23', 123, 6.1, 18, 13, 'Peri Baumeister, Alexander Scheer, Kais Setti'),
    (14, 'Ghost Lab', 'Two doctors obsessed with proving ghosts exist after witnessing a haunting.', '2021-05-26', 117, 5.1, 16, 14, 'Thanapob Leeratanakachorn, Paris Intarakomalyasut, Nuttanicha Dungwattanawanich'),
    (15, 'Mirrors', 'An ex-cop night guard discovers malevolent spirits haunting mirrors.', '2008-08-15', 111, 6.2, 16, 15, 'Kiefer Sutherland, Paula Patton, Cameron Boyce'),
    (16, 'My Travel Buddy', 'Salesman visits girlfriend''s family, trip goes astray due to crazy travel buddy.', '2017-11-10', 117, 6.3, 10, 16, 'Oguzhan Koç, İbrahim Büyükak, Emre Kınay'),
    (17, 'Recep Ivedik', 'A man finds a rich man’s wallet, takes a trip and finds old love and luxury.', '2008-02-22', 101, 5.7, 13, 17, 'Şahan Gökbakar, Fatma Toptaş, Tuluğ Çizgen'),
    (18, 'Hababam Class', 'Co-ed chaos and rivalry at Private Camlica High School.', '2019-04-05', 106, 4.8, 10, 18, 'Altan Erkekli, Toygan Avanoğlu, Hande Katipoğlu'),
    (19, 'We Can Be Heroes', 'Action-adventure based on "The Adventures of Sharkboy and Lavagirl."', '2020-12-25', 100, 4.7, 7, 19, 'YaYa Gosselin, Pedro Pascal, Priyanka Chopra Jonas'),
    (20, 'Little Man', 'Man eager to become dad believes a thief is a baby.', '2006-07-14', 97, 4.4, 13, 20, 'Marlon Wayans, Shawn Wayans, Kerry Washington'),
    (21, 'I Am Mother', 'Teen raised by a maternal droid faces world shaken by another human.', '2019-01-25', 113, 6.7, 13, 21, 'Clara Rugaard, Rose Byrne, Hilary Swank'),
    (22, 'Mirage', 'Nurse alters past, her reality shifts to new timeline without her daughter.', '2018-11-30', 129, 7.4, 16, 22, 'Adriana Ugarte, Chino Darin, Javier Gutiérrez'),
    (23, 'Paradise', 'People sell years of their lives to others with terrifying consequences.', '2023-07-27', 118, 6.5, 16, 23, 'Kostja Ullmann, Corinna Kirchhoff, Marlene Tanczik'),
    (24, 'After Earth', 'Boy searches for beacon to save himself and dying father after crash landing on Earth.', '2013-05-31', 100, 4.8, 13, 24, 'Jaden Smith, Will Smith, Sophie Okonedo'),
    (25, 'Extinction', 'Family man plagued by alien invasion dreams faces extraterrestrial force exterminating Earth.', '2018-07-27', 105, 5.8, 16, 25, 'Michael Peña, Lizzy Caplan, Israel Broussard'),
    (26, 'Boss Baby', 'Kid caught in corporate plot when parents bring home a business-speaking baby.', '2017-03-31', 97, 6.3, 7, 26, 'Alec Baldwin, Lisa Kudrow, Jimmy Kimmel'),
    (27, 'Madagascar', 'Four animals escape captivity and end up on Madagascar island.', '2005-05-27', 86, 6.9, 7, 27, 'Ben Stiller, Chris Rock, David Schwimmer'),
    (28, 'Alvin And The Chipmunks', 'Chipmunks and Chipettes castaways on a deserted island after boarding cruise liner.', '2011-12-16', 87, 4.3, 7, 28, 'Jason Lee, David Cross, Jenny Slate'),
    (29, 'My Little Pony', 'Hero tries to unite Earth Ponies, Pegasi and Unicorns in Equestria.', '2021-09-24', 91, 6.6, 6, 29, 'Vanessa Hudgens, Kimiko Glenn, James Marsden'),
    (30, 'Barbie Dolphin Magic', 'Barbie explores coral reef and meets a mysterious new friend.', '2017-10-13', 64, 5.6, 6, 30, 'Erica Lindbeck, Shannon Chan-Kent, Kazumi Evans');
""");


            // Romantic Movies
            stmt.executeUpdate("""
            INSERT INTO romantic_movies (movie_id)
            SELECT movie_id FROM movies WHERE title IN (
                'Heart Parade',
                'In Good Hands',
                'Love Tactics',
                'Last Call For Istanbul',
                'Ashes'
            )
        """);

            // Action Movies
            stmt.executeUpdate("""
            INSERT INTO action_movies (movie_id)
            SELECT movie_id FROM movies WHERE title IN (
                'Red Notice',
                'Extraction',
                'Fast and Furious 7',
                'The Maze Runner',
                'Now You See Me'
            )
        """);

            // Horror Movies
            stmt.executeUpdate("""
            INSERT INTO horror_movies (movie_id)
            SELECT movie_id FROM movies WHERE title IN (
                'Countdown',
                'Bird Box',
                'Blood Red Sky',
                'Ghost Lab',
                'Mirrors'
            )
        """);

            // Comedy Movies
            stmt.executeUpdate("""
            INSERT INTO comedy_movies (movie_id)
            SELECT movie_id FROM movies WHERE title IN (
                'My Travel Buddy',
                'Recep Ivedik',
                'Hababam Class'
            )
        """);


            //All Series:
            stmt.executeUpdate("""
    INSERT INTO series (series_id, title, description, release_date, seasons, rating, age_limit, director_id, actors) VALUES
    (1, 'Lupin', 'Acclaimed French actor Omar Sy plays a winsome thief who outwits the rich and powerful.', '2021-01-08', 3, 8.0, 16, 1, 'Omar Sy, Ludivine Sagnier, Clotilde Hesme, Nicole Garcia, Hervé Pierre'),
    (2, 'The Walking Dead', 'In the wake of a zombie apocalypse, survivors fight to stay alive.', '2010-10-31', 11, 8.2, 18, 2, 'Andrew Lincoln, Steven Yeun, Norman Reedus, Chandler Riggs, Melissa McBride'),
    (3, 'Narcos', 'True story of Colombia''s violent drug cartels.', '2015-08-28', 3, 8.8, 18, 3, 'Wagner Moura, Pedro Pascal, Boyd Holbrook, Damién Alcazar'),
    (4, 'The Protector', 'A young man in Istanbul discovers his connection to an ancient secret society.', '2018-12-14', 4, 6.7, 16, 4, 'Çağatay Ulusoy, Ayça Ayşin Turan, Hazar Ergüçlü'),
    (5, 'La Casa De Papel', 'Eight thieves lock themselves in the Royal Mint of Spain.', '2017-05-02', 5, 8.3, 18, 5, 'Ursula Corbero, Alvaro Morte, Itziar Ituño, Pedro Alonso'),
    (6, 'Stranger Things', 'Kids investigate supernatural events in their town.', '2016-07-15', 4, 8.7, 14, 6, 'Winona Ryder, David Harbour, Millie Bobby Brown, Finn Wolfhard'),
    (7, 'Chilling Adventures of Sabrina', 'Teen witch Sabrina faces sinister events.', '2018-10-26', 4, 7.4, 16, 7, 'Kiernan Shipka, Ross Lynch, Miranda Otto, Lucy Davis'),
    (8, 'Hellbound', 'Humans face otherworldly threats in this horror thriller.', '2021-11-19', 1, 6.6, 18, 8, 'Yoo Ah-in, Kim Hyun-joo, Park Jeong-min'),
    (9, 'Parasyte: The Grey', 'Alien parasite and woman try to save humanity.', '2014-10-08', 1, 7.0, 16, 9, 'Jeon So-nee, Koo Kyo-hwan, Lee Jung-hyun'),
    (10, 'Van Helsing', 'A woman fights to survive a vampire-ravaged world.', '2016-09-23', 5, 6.2, 18, 10, 'Kelly Overton, Jonathan Scarfe, Christopher Heyerdahl'),
    (11, 'Bir Erkek Bir Kadın', 'A couple navigates life''s comic situations.', '2008-02-14', 1, 7.5, 12, 11, 'Demet Evgar, Emre Karayel'),
    (12, 'Emily in Paris', 'Marketing exec Emily adapts to life in Paris.', '2020-10-02', 3, 6.9, 13, 12, 'Lily Collins, Philippine Leroy-Beaulieu, Ashley Park'),
    (13, 'Friends', 'Six friends deal with love and life in 1990s NYC.', '1994-09-22', 10, 8.9, 13, 13, 'Jennifer Aniston, Courteney Cox, Lisa Kudrow, Matt LeBlanc'),
    (14, 'How I Met Your Mother', 'Ted tells kids how he met their mother.', '2005-09-19', 9, 8.3, 13, 14, 'Josh Radnor, Cobie Smulders, Neil Patrick Harris'),
    (15, 'Orange is The New Black', 'A woman adapts to life in prison.', '2013-07-11', 7, 8.1, 18, 15, 'Taylor Schilling, Kate Mulgrew, Laura Prepon, Jason Biggs'),
     (16, 'Thank You Next', 'Modern-day pains of 30-year-old lawyer Leyla and her friends.', '2023-01-15', 1, 7.0, 16, 16, 'Serenay Sarıkaya, Metin Akdülger, Hakan Kurtaş, Boran Kuzum'),
                        (17, 'Bridgerton', 'Eight siblings seek love and happiness in London high society.', '2020-12-25', 2, 7.3, 16, 17, 'Adjoa Andoh, Jonathan Bailey, Ruby Barker, Phoebe Dynevor'),
                        (18, 'One Day', 'Lives of Emma Morley and Dexter Mayhew from their last day at university.', '2022-03-10', 1, 6.8, 14, 18, 'Ambika Mod, Leo Woodall, Essie Davis, Tim McInnerny'),
                        (19, 'Shahmaran', 'A young woman finds her soulmate and an ancient legend.', '2021-09-15', 1, 6.5, 16, 19, 'Serenay Sarıkaya, Burak Deniz, Mustafa Uğurlu'),
                        (20, 'Ginny & Georgia', 'Georgia raises Ginny while trying to provide a fresh start.', '2021-02-24', 2, 7.1, 14, 20, 'Brianne Howey, Antonia Gentry, Diesel La Torraca'),
                        (21, 'Lucifer', 'Lucifer Morningstar punishes humans as the lord of Hell.', '2016-01-25', 6, 8.1, 18, 21, 'Tom Ellis, Lauren German, Kevin Alejandro'),
                        (22, 'The Witcher', 'Epic tale of monsters, magic and destiny.', '2019-12-20', 3, 8.2, 18, 22, 'Henry Cavill, Anya Chalotra, Freya Allan'),
                        (23, 'One Piece', 'Luffy begins his journey to find pirate king''s treasure.', '2023-08-01', 1, 7.8, 13, 23, 'Iñaki Godoy, Emily Rudd, Mackenyu'),
                        (24, 'Wednesday', 'Wednesday Addams investigates murders at Nevermore Academy.', '2022-11-23', 1, 7.9, 16, 24, 'Jenna Ortega, Gwendoline Christie, Riki Lindhome'),
                        (25, 'Locke & Key', 'Siblings discover magical keys after their dad''s murder.', '2020-02-07', 3, 7.5, 16, 25, 'Darby Stanchfield, Connor Jessup, Emilia Jones'),
                        (26, 'SpongeBob Squarepants', 'Memorable misadventures of SpongeBob and friends.', '1999-05-01', 7, 8.7, 7, 26, 'Tom Kenny, Rodger Bumpass, Bill Fagerbakke'),
                        (27, 'Miraculous: Tales of Ladybug and Cat Noir', 'Marinette transforms into Ladybug to save Paris.', '2015-10-19', 4, 7.8, 7, 27, 'Cristina Valenzuela, Bryce Papenbrook, Keith Silverstein'),
                        (28, 'Ben10', 'Ben Tennyson morphs into alien superheroes.', '2005-12-27', 3, 7.0, 7, 28, 'Tara Strong, Paul Eiding, Meagan Smith'),
                        (29, 'Adventure Time', 'Surreal adventures of Finn and his dog Jake.', '2010-04-05', 4, 8.6, 10, 29, 'Jeremy Shada, John DiMaggio, Hynden Walch'),
                        (30, 'World of Winx', 'Five young fairies learn to control their powers at Alfea.', '2019-06-01', 2, 6.7, 10, 30, 'Haven Paschall, Alysha Deslorieux, Jessica Paquet');
""");

            //ROMANTIC SERIES
            stmt.executeUpdate("""
               INSERT INTO romantic_series (series_id)
                       SELECT series_id FROM series WHERE title IN (
                           'Thank You Next',
                           'Bridgerton',
                           'One Day',
                           'Shahmaran',
                           'Ginny & Georgia'
               )
        """);


            //ACTION SERIES
            stmt.executeUpdate("""
              INSERT INTO action_series (series_id)
                      SELECT series_id FROM series WHERE title IN (
                          'Lupin',
                          'The Walking Dead',
                          'Narcos',
                          'The Protector',
                          'La Casa De Papel'
                      )
        """);

            //HORROR SERIES
            stmt.executeUpdate("""
              INSERT INTO horror_series (series_id)
                      SELECT series_id FROM series WHERE title IN (
                          'Stranger Things',
                          'Chilling Adventures of Sabrina',
                          'Hellbound',
                          'Parasyte: The Grey',
                          'Van Helsing'
                      )
        """);

            //COMEDY SERIES
            stmt.executeUpdate("""
              INSERT INTO comedy_series (series_id)
                      SELECT series_id FROM series WHERE title IN (
                          'Bir Erkek Bir Kadın',
                          'Emily in Paris',
                          'Friends',
                          'How I Met Your Mother (HIMYM)',
                          'Orange Is The New Black'
                      )
        """);

            //SCI-Fİ SERIES
            stmt.executeUpdate("""
              INSERT INTO sci_fi_and_fantasy_series (series_id)
                      SELECT series_id FROM series WHERE title IN (
                          'Lucifer',
                          'The Witcher',
                          'One Piece',
                          'Wednesday',
                          'Locke & Key'
                      )
        """);

            //FAMILY AND CHILDREN SERIES
            stmt.executeUpdate("""
              INSERT INTO family_and_children_series (series_id)
                      SELECT series_id FROM series WHERE title IN (
                          'SpongeBob Squarepants',
                          'Miraculous: Tales of Ladybug and Cat Noir',
                          'Ben10',
                          'Adventure Time',
                          'World of Winx'
                      )
        """);
            stmt.close();

            System.out.println("Seed işlemi başarıyla tamamlandı.");

        } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Seed işlemi sırasında hata oluştu.");
        }
    }*/
}
