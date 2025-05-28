package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void main(String[] args) {
       /*
        try (Connection conn = DatabaseConfig.connect();
             Statement stmt = conn.createStatement()) {

            //popular_this_week
            stmt.execute("""
CREATE TABLE popular_this_week (
  pop_id INT PRIMARY KEY,
  title VARCHAR(255),
  description TEXT,
  release_date DATE,
  duration INT,
  rating FLOAT,
  age_limit INT,
  director_id INT,
  type VARCHAR(20),
  FOREIGN KEY (director_id) REFERENCES directors(director_id)
);
""");

            //new_releases
            stmt.execute("""
                    CREATE TABLE new_releases (
                        id SERIAL PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        description TEXT,
                        duration INT,
                        rating FLOAT,
                        age_limit INT,
                        director_id INT REFERENCES directors(director_id),
                        type VARCHAR(20) NOT NULL CHECK (type IN ('movie', 'series'))
                    );
            """);

            // users
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS users (
                    user_id SERIAL PRIMARY KEY,
                    username VARCHAR(50),
                    email VARCHAR(100),
                    password VARCHAR(100)
                );
            """);

            // movies
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS movies (
                    movie_id SERIAL PRIMARY KEY,
                    title VARCHAR(255),
                    description TEXT,
                    release_date DATE,
                    duration INT,
                    rating FLOAT,
                    age_limit INT,
                    director_id INT REFERENCES directors(director_id)
                    actors TEXT
                );
            """);

            // series
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS series (
                    series_id SERIAL PRIMARY KEY,
                    title VARCHAR(255),
                    description TEXT,
                    release_date DATE,
                    seasons INT,
                    rating FLOAT,
                    age_limit INT,
                    director_id INT REFERENCES directors(director_id)
                    actors TEXT
                );
            """);


            // movie_comments
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS movie_comments (
                    comment_id SERIAL PRIMARY KEY,
                    user_id INT REFERENCES users(user_id),
                    movie_id INT REFERENCES movies(movie_id),
                    content TEXT,
                    created_at TIMESTAMP
                );
            """);

            // series_comments
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS series_comments (
                    comment_id SERIAL PRIMARY KEY,
                    user_id INT REFERENCES users(user_id),
                    series_id INT REFERENCES series(series_id),
                    content TEXT,
                    created_at TIMESTAMP
                );
            """);

            // users_favourites
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS users_favourites (
                    fav_id SERIAL PRIMARY KEY,
                    title VARCHAR(255),
                    description TEXT,
                    release_date DATE,
                    duration INT,
                    rating FLOAT,
                    age_limit INT,
                    director_id INT REFERENCES directors(director_id),
                    type VARCHAR(20)
                );
            """);

            // movie categories
            stmt.execute("CREATE TABLE IF NOT EXISTS romantic_movies (movie_id INT PRIMARY KEY REFERENCES movies(movie_id));");
            stmt.execute("CREATE TABLE IF NOT EXISTS comedy_movies (movie_id INT PRIMARY KEY REFERENCES movies(movie_id));");
            stmt.execute("CREATE TABLE IF NOT EXISTS action_movies (movie_id INT PRIMARY KEY REFERENCES movies(movie_id));");
            stmt.execute("CREATE TABLE IF NOT EXISTS scifi_fantasy_movies (movie_id INT PRIMARY KEY REFERENCES movies(movie_id));");
            stmt.execute("CREATE TABLE IF NOT EXISTS horror_thriller_movies (movie_id INT PRIMARY KEY REFERENCES movies(movie_id));");
            stmt.execute("CREATE TABLE IF NOT EXISTS family_children_movies (movie_id INT PRIMARY KEY REFERENCES movies(movie_id));");

            // series categories
            stmt.execute("CREATE TABLE IF NOT EXISTS romantic_series (series_id INT PRIMARY KEY REFERENCES series(series_id));");
            stmt.execute("CREATE TABLE IF NOT EXISTS comedy_series (series_id INT PRIMARY KEY REFERENCES series(series_id));");
            stmt.execute("CREATE TABLE IF NOT EXISTS action_series (series_id INT PRIMARY KEY REFERENCES series(series_id));");
            stmt.execute("CREATE TABLE IF NOT EXISTS scifi_fantasy_series (series_id INT PRIMARY KEY REFERENCES series(series_id));");
            stmt.execute("CREATE TABLE IF NOT EXISTS horror_thriller_series (series_id INT PRIMARY KEY REFERENCES series(series_id));");
            stmt.execute("CREATE TABLE IF NOT EXISTS family_children_series (series_id INT PRIMARY KEY REFERENCES series(series_id));");

            System.out.println("All tables were created successfully.");

        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        */
    }
}
