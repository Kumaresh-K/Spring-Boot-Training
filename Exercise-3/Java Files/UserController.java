package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/banking")
public class UserController {
	
	@Autowired
	UserServices userService;
	@Autowired
	BankingService bankingService;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView home (ModelAndView mandv) {
		mandv.setViewName("home");
		return mandv;
	}
	
	@RequestMapping(value="/create_account", method=RequestMethod.GET)
	public ModelAndView createUser(ModelAndView mandv) {
		User user=new User();
		mandv.addObject("user",user);
		mandv.setViewName("create_account");
		return mandv;
	}
	
	@RequestMapping(value="/create_account", method=RequestMethod.POST)
	public ModelAndView addUser(User user, ModelAndView mandv) {
		mandv.setViewName("successful_account");
		userService.createUser(user);
		return mandv;
	}
	
	@RequestMapping(value="/find_account", method=RequestMethod.GET)
	public ModelAndView sendFindAccount(User user, ModelAndView mandv) {
		mandv.addObject(user);
		mandv.setViewName("find_account");
		return mandv;
	}
	
	@RequestMapping(value="/find_account", method=RequestMethod.POST)
	public ModelAndView findAccount(User user, ModelAndView mandv) {
	
		user = userService.getUser(user.getUserid());
		mandv.addObject(user);
		mandv.setViewName("account_details");
		return mandv;
	}
	
	@RequestMapping(value="/money_transfer", method=RequestMethod.GET)
	public ModelAndView sendMoneyTransfer(Transfer transfer, ModelAndView mandv) {
		mandv.addObject(transfer);
		mandv.setViewName("money_transfer");
		return mandv;
	}
	
	@RequestMapping(value="/money_transfer", method=RequestMethod.POST)
	public ModelAndView moneyTransfer(Transfer transfer, ModelAndView mandv) throws InsufficientBalanceException {
		bankingService.transferAmount(transfer.getCreditID(), transfer.getDebitID(), transfer.getAmount());
		mandv.setViewName("successful_transaction");
		return mandv;
	}
}

class Transfer {
	private String creditID, debitID;
	private int amount;
	
	public String getCreditID() {
		return creditID;
	}
	public void setCreditID(String creditID) {
		this.creditID = creditID;
	}
	public String getDebitID() {
		return debitID;
	}
	public void setDebitID(String debitID) {
		this.debitID = debitID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
