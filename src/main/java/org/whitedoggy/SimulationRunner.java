package org.whitedoggy;

import org.whitedoggy.banner.Banner;
import org.whitedoggy.banner.BannerSelector;
import org.whitedoggy.character.Character;
import org.whitedoggy.character.CharacterGroup;
import org.whitedoggy.character.Rarity;

import java.util.Random;

public class SimulationRunner {
    private final BannerSelector bannerSelector;
    private final Random random = new Random();

    public SimulationRunner(BannerSelector bannerSelector) {
        this.bannerSelector = bannerSelector;
    }

    public void run(int simulationCount, int pickupCount, double limit) {
        int count = 0;
        for (int sim = 0; sim < simulationCount; sim++) {
            boolean c1 = false;
            boolean c2 = false;
            boolean b2Used = false;

            int b1 = 0;
            int b2 = 0;
            int b3 = 0;
            int b4 = 0;

            double[] groupScores = new double[CharacterGroup.values().length];
            StringBuilder pickedCharacters = new StringBuilder();
            for (int pickup = 0; pickup < pickupCount; pickup++) {
                Banner banner = bannerSelector.select(pickup, c1, c2, b2Used);
                if(banner.isGuaranteedSSR()){
                    if (random.nextDouble() < banner.isValid())
                        continue;
                    Character c = banner.rollCharacter(random);
                    pickedCharacters.append(c.getName()).append(" [+" + c.getScore() + "]\n");
                    int groupIndex = c.getGroup().ordinal();
                    groupScores[groupIndex] =
                            Math.max(groupScores[groupIndex], c.getScore());
                    if(c.getName().equals("료슈 - 로보토미 E.G.O 잔향·외로움")) {c1 = true;}
                    if(c.getName().equals("뫼르소 - 로보토미 E.G.O 호넷 [변조]")) {c2 = true;}
                }
                for (int i = 0; i < banner.getPickupCount(); i++) {
                    Rarity rarity = banner.rollRarity(random);
                    if (rarity != Rarity.SSR)
                        continue;
                    if (random.nextDouble() < banner.isValid())
                        continue;
                    Character c = banner.rollCharacter(random);
                    pickedCharacters.append(c.getName()).append(" [+" + c.getScore() + "]\n");
                    int groupIndex = c.getGroup().ordinal();
                    groupScores[groupIndex] =
                            Math.max(groupScores[groupIndex], c.getScore());
                    if(c.getName().equals("료슈 - 로보토미 E.G.O 잔향·외로움")) {c1 = true;}
                    if(c.getName().equals("뫼르소 - 로보토미 E.G.O 호넷 [변조]")) {c2 = true;}
                }
                if(banner.getBannerType() == 1){
                    b1++;
                }
                if(banner.getBannerType() == 2){
                    b2++;
                    b2Used = true;
                }
                if(banner.getBannerType() == 3){
                    b3++;
                }
                if(banner.getBannerType() == 4){
                    b4++;
                }
            }
            double score = 0;
            for (double s : groupScores)
                score += s;
            if (score >= limit) {
                count++;
                System.out.println("시뮬레이션 " + sim + "회, 점수 = " + score);
                System.out.println("[픽업 횟수]");
                System.out.println("3선권 = " + b3 +  "회, " + "발푸밤 = " + b1 +  "회, " + "일반(20회 천장) = " + b2 + "회, " + "일반 = " + b4 + "회");
                System.out.println("[캐릭터]\n" + pickedCharacters);
            }
        }
        double per = (double) count / simulationCount * 100;
        System.out.println("-------------------");
        System.out.println("시뮬레이션 횟수: " + simulationCount + "회");
        System.out.println("시뮬레이션 동안 " + count + "회의 유효 계정이 등장했습니다.");
        System.out.println("유효 확률: " + per + "%");
    }
}