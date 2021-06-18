package in.siva.validator;

import in.siva.exception.ValidationException;
import in.siva.model.MatchDetail;

public class MatchDetailValidator {

	private MatchDetailValidator() {

	}

	public static void isValidMatchDetail(MatchDetail matchDetail) {

		int availableSeats = matchDetail.getAvailableSeats();
		int totalseats = matchDetail.getTotalSeats();
		int upperSeatPrice = matchDetail.getUpperSeatPrice();
		int lowerSeatprice = matchDetail.getLowerSeatPrice();
		String team1 = matchDetail.getTeamOne();
		String team2 = matchDetail.getTeamTwo();
		String image = matchDetail.getImage();
		if (!InputValidator.isValidNumber(lowerSeatprice) || !InputValidator.isValidNumber(upperSeatPrice)
				|| !InputValidator.isValidNumber(totalseats)
				|| !InputValidator.isValidNumber(availableSeats) && !InputValidator.isValidString(image)
				|| !InputValidator.isValidString(team2) || !InputValidator.isValidString(team1)) {
			throw new ValidationException("Invalid");
		}
		if(team1.equals(team2)) {
			throw new ValidationException("Team name should be unique");
		}
	}

}
