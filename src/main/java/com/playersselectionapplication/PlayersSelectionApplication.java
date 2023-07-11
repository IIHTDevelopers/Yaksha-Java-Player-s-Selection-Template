package com.playersselectionapplication;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import org.jboss.jandex.Main;

import com.playersselectionapplication.repository.PlayerDAO;
import com.playersselectionapplication.repository.PlayerDAOImpl;
import com.playersselectionapplication.repository.ScoreDAO;
import com.playersselectionapplication.repository.ScoreDAOImpl;

public class PlayersSelectionApplication {
	private static PlayerDAO playerDAO;
	private static ScoreDAO scoreDAO;

	public static void main(String[] args) {
		try {
			InputStream input = Main.class.getClassLoader().getResourceAsStream("application.properties");
			Properties props = new Properties();
			props.load(input);
			String url = props.getProperty("db.url");
			String username = props.getProperty("db.username");
			String password = props.getProperty("db.password");

			createDatabaseIfNotExists(url, username, password);
			createTablesIfNotExists(url, username, password);

			playerDAO = new PlayerDAOImpl();
			scoreDAO = new ScoreDAOImpl();

			showOptions();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	private static void createDatabaseIfNotExists(String url, String username, String password) throws SQLException {
		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement()) {

			String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS your_database_name";
			statement.executeUpdate(createDatabaseQuery);
		}
	}

	private static void createTablesIfNotExists(String url, String username, String password) throws SQLException {
		String createPlayerTableQuery = "CREATE TABLE IF NOT EXISTS Player (" + "id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "name VARCHAR(10) NOT NULL," + "domesticTeam VARCHAR(255) NOT NULL,"
				+ "average INT NOT NULL DEFAULT 0" + ")";

		String createScoreTableQuery = "CREATE TABLE IF NOT EXISTS Score (" + "id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "score INT NOT NULL," + "playerId INT NOT NULL," + "FOREIGN KEY (playerId) REFERENCES Player(id)"
				+ ")";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement()) {

			statement.executeUpdate(createPlayerTableQuery);
			statement.executeUpdate(createScoreTableQuery);
		}
	}

	private static void showOptions() throws SQLException {
	}

	private static void addPlayer(Scanner scanner) throws SQLException {
	}

	private static void addScore(Scanner scanner) throws SQLException {
	}

	private static void updatePlayer(Scanner scanner) throws SQLException {
	}

	private static void updateScore(Scanner scanner) throws SQLException {
	}

	private static void deletePlayer(Scanner scanner) throws SQLException {
	}

	private static void deleteScore(Scanner scanner) throws SQLException {
	}

	private static void showAllPlayers() throws SQLException {
	}

	private static void showAllScores() throws SQLException {
	}

	private static void searchPlayersByName(Scanner scanner) throws SQLException {
	}

	private static void searchPlayersByDomesticTeam(Scanner scanner) throws SQLException {
	}

	private static void getScoresByPlayerId(Scanner scanner) throws SQLException {
	}

	private static void getAverageOfLastThreeScores(Scanner scanner) throws SQLException {
	}
}
