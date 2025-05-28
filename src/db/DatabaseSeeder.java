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
