package dao;

import java.io.Serializable;

/**
 * 
 * @author guillaumeO
 *
 */
public class DaoException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int code;
	
	public DaoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DaoException(String message, int code) {
		super(message);
		this.code=code;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	
}
