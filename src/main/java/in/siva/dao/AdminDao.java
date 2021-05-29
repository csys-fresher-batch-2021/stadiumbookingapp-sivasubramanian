package in.siva.dao;

import java.sql.SQLException;

import in.siva.exception.DbException;
import in.siva.model.MatchDetail;

public interface AdminDao {

	public void save(MatchDetail dao) throws DbException, SQLException;

}
