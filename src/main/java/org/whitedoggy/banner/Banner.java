package org.whitedoggy.banner;

import org.whitedoggy.character.Character;
import org.whitedoggy.character.Rarity;

import java.util.Random;

public class Banner {
    private final double announceRate;
    private final double egoRate;
    private final double ssrRate;
    private final double srRate;
    private final org.whitedoggy.character.Character[] validCharacters;
    private final int[] weights;
    private final int totalWeight;
    private final boolean guaranteedSSR;
    private final double valid;
    private final int pickupCount;
    private final int bannerType;

    public Banner(
            double announceRate,
            double egoRate,
            double ssrRate,
            double srRate,
            org.whitedoggy.character.Character[] validCharacters,
            int[] weights,
            boolean guaranteedSSR,
            double valid,
            int pickupCount,
            int bannerType
    ) {
        this.announceRate = announceRate;
        this.egoRate = egoRate;
        this.ssrRate = ssrRate;
        this.srRate = srRate;
        this.validCharacters = validCharacters;
        this.weights = weights;
        this.guaranteedSSR = guaranteedSSR;
        this.valid = valid;
        this.pickupCount = pickupCount;
        this.bannerType = bannerType;

        int sum = 0;
        for (int w : weights) sum += w;
        this.totalWeight = sum;
    }

    public Rarity rollRarity(Random random) {
        double r = random.nextDouble();
        if (r < announceRate)
            return Rarity.Announce;
        if (r < announceRate + egoRate)
            return Rarity.EGO;
        if (r < announceRate + egoRate + ssrRate)
            return Rarity.SSR;
        if (r < announceRate + egoRate + ssrRate + srRate)
            return Rarity.SR;
        return Rarity.R;
    }

    public Character rollCharacter(Random random) {
        int r = random.nextInt(totalWeight);
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (r < sum)
                return validCharacters[i];
        }
        return validCharacters[0];
    }

    public int getBannerType() {return bannerType;}
    public boolean isGuaranteedSSR() {return guaranteedSSR;}
    public double isValid() {
        return valid;
    }
    public int getPickupCount() {return pickupCount;}
}