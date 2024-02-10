package com.OfferLetter;

import java.io.UnsupportedEncodingException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

	@Autowired
	private OfferRepository offerRepository;
	@Autowired
	private JavaMailSender javaMailSender;
	
	private OfferLetter offerLetter;
	
	
	@Override
	public OfferLetter saveEnrollment(OfferLetter offerLetter) {
		
		return offerRepository.save(offerLetter);
	}

	@Override
	public void sendOfferLetter(String to , String name) throws Exception , UnsupportedEncodingException {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper( message , true);
		
		String subject="INTERNSHIP OFFER LETTER";
		
		String content="<p><b>Congratulations!<b></p>" +"<b>" + name + "<b>"
	            + "<p><b>You are selected for the DS Technologies Internship program. Kindly check the offer letter attached with this Email.<b></p>"
	            + "<p><b>Internship Start Date: 10th February 2024<b></p>"
	            + "<p><b>Internship End Date: 10th May 2024<b></p>"
	            + "<br>"
	            + "<p><b>Stipend- 27000/month<b><p>"
	            + "<p>Task will be assigned to you soon.</p>"
		        + "<p>We are pleased to offer you the Internship in our company, we would like to inform you that for the completion of the Internship you have to complete task(s) assigned to you in the given time interval in the offer letter</p>"
		        + "<br>"
		        + "<p>Here is the list of steps that are necessary for the completion of the Internship. You must have to complete these in the duration of the internship\r\n"
		        + "<p>1).  You have to update your LinkedIn profile and share all your achievements (Offer Letter/ Internship Completion Certificate) Which you got from DS Technologies and tag DS Technologies official LinkedIn page and use the relevant hashtags such as <b>@DS Technologies<b> & <b>#DS Technologies<b></p>"
		        + "<p>2).  Share a proper video of Completed task on LinkedIn, tag us and use relevant hashtags.</p>"
		        + "<p>3).  Share the GitHub link where there should be a separate repository with the name of the task completed by you containing all the relevant files of the task.  You have to share this link in the video of completed tasks in LinkedIn also in the task completion link which will be shared to you later through email.</p>"
				+ "<br>"
		        + "<p>Failing any task would be considered as the Incompletion of internship. The internship certificate will be shared to the deserving candidates only after the completion of the internship within the duration mentioned in the offer letter.</p>"
				+ "<p><b>Congratulations!<b> Once again on being selected.</p>"
		        + "<p>Join us Through</p>"
				+ "<p>LinkedIn</p>"
		        + "<p>Telegram</p>"
				+ "<p>Join on the WhatsApp Group</p>"
		        + "<br>"
		        + "<p>Best Regards,</p>"
		        + "<p><b>DS Technologies<b></p>";
		helper.setFrom("support@DSTechnologies.com" , "DS Technologies");
		helper.setTo(to);
		
		helper.setSubject(subject);
		helper.setText(content , true);
		javaMailSender.send(message);
	}

}
