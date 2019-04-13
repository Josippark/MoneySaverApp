package hr.java.web.pavlovic.moneyapp.controller;

import hr.java.web.pavlovic.moneyapp.model.Expense;
import hr.java.web.pavlovic.moneyapp.model.ExpenseType;
import hr.java.web.pavlovic.moneyapp.model.Wallet;
import hr.java.web.pavlovic.moneyapp.model.WalletType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/expense")
@SessionAttributes({"types", "wallet", "walletList"})
public class ExpenseController {


    @ModelAttribute("wallet")
    public Wallet loadWallet() {
        Wallet wallet = new Wallet(0,"Moj Wallet", WalletType.TEKUĆI);
        log.info("Loading wallet: Balance: " + wallet.getBalance());
        log.info("Loading wallet: Type of Wallet: " + wallet.getWalletType());
        return wallet;
    }

    @GetMapping("/new")
    public String showHome(Model model) {
        model.addAttribute("expense", new Expense());
        model.addAttribute("types", ExpenseType.values());
        log.info("Insert form for new item");
        return "new";
    }

    @PostMapping("/new")
    public String processForm(@Validated Expense expense, Errors errors, @ModelAttribute("wallet") Wallet wallet, Model model) {
        model.addAttribute("expense", expense);
        if (errors.hasErrors()) {
            log.info("Errors inserted, returning view - new");
            return "new";
        }

        wallet.setBalance(wallet.getBalance() - expense.getCost());

        log.info("Accepted item");
        return "accepted";
    }


    @GetMapping("/endsession")
    public ModelAndView endSession(SessionStatus status) {
        status.setComplete();
        return new ModelAndView("redirect:/expense/new");
    }
}