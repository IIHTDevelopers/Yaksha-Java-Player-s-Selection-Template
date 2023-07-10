package com.playersselectioniapplication.repository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.playersselectioniapplication.model.Score;

public class ScoreDAOImpl implements ScoreDAO {
	private final String url;
	private final String username;
	private final String password;

	public ScoreDAOImpl() {
		Properties properties = new Properties();
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties")) {
			if (inputStream == null) {
				throw new RuntimeException("application.properties file not found");
			}
			properties.load(inputStream);
			url = properties.getProperty("db.url");
			username = properties.getProperty("db.username");
			password = properties.getProperty("db.password");
		} catch (IOException e) {
			throw new RuntimeException("Failed to load application.properties file", e);
		}
	}

	@Override
	public void addScore(Score score) throws SQLException {
	}

	@Override
	public void updateScore(Score score) throws SQLException {
	}

	@Override
	public void deleteScore(Score score) throws SQLException {
	}

	@Override
	public Score getScoreById(int id) throws SQLException {
		return null;
	}

	@Override
	public List<Score> getAllScores() throws SQLException {
		return null;
	}

	@Override
	public List<Score> getScoresByPlayerId(int playerId) throws SQLException {
		return null;
	}

	@Override
	public double getAverageOfLastThreeScores(int playerId) throws SQLException {
		return 0;
	}
}
