package org.example;

public class BaseBallCoach implements Coach{

    private FortuneService fortuneService;

    public BaseBallCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "practice back volley today";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
