package org.whitedoggy;

import org.whitedoggy.banner.Banner;
import org.whitedoggy.banner.BannerSelector;
import org.whitedoggy.character.Character;
import org.whitedoggy.character.CharacterGroup;

public class Main {

    public static void main(String[] args) {
        Character[] poolBanner1 = {
                new Character("이상 - 거미집 검지 아비", CharacterGroup.I, 1.2),
                new Character("이상 - 약지 점묘파 스튜던트", CharacterGroup.I, 0.7),

                new Character("파우스트 - 흑수·묘 필두", CharacterGroup.II, 1.2),

                //new Character("돈키호테 - 동부 생크 협회 3과", CharacterGroup.III, 0.5),
                new Character("돈키호테 - 검지 대행자 - 개화 E.G.O 대행", CharacterGroup.III, 1.0),
                new Character("돈키호테 - 로보토미 E.G.O 사랑과 증오의 이름으로", CharacterGroup.III, 0.7),

                new Character("료슈 - 로보토미 E.G.O 잔향·외로움", CharacterGroup.IV, 1.2),
                new Character("료슈 - 로보토미 E.G.O 적안·참회", CharacterGroup.IV, 0.7),

                new Character("뫼르소 - 동부 엄치 카포 IIII", CharacterGroup.V, 1.2),
                new Character("뫼르소 - 서부 생크 협회 3과", CharacterGroup.V, 0.7),
                new Character("뫼르소 - 로보토미 E.G.O 호넷 [변조]", CharacterGroup.V, 1.0),

                new Character("홍루 - 홍원 군주", CharacterGroup.VI, 1.2),
                new Character("홍루 - 마침표 사무소 대표", CharacterGroup.VI, 1.0),

                new Character("히스클리프 - 와일드헌트", CharacterGroup.VII, 0.7),
                new Character("히스클리프 - 흑수·유 필두", CharacterGroup.VII, 0.7),
                new Character("히스클리프 - 마침표 사무소 해결사", CharacterGroup.VII, 1.0),

                //new Character("이스마엘 - 서부 츠바이 협회 3과", CharacterGroup.VIII, 0.5),
                new Character("이스마엘 - 정사무소 대표", CharacterGroup.VIII, 1.0),

                new Character("로쟈 - 로보토미 E.G.O 눈물로 벼려낸 검", CharacterGroup.IX, 1.2),

                //new Character("싱클레어 - 남부 생크 협회 4과 부장", CharacterGroup.X, 0.5),
                new Character("싱클레어 - 거미집 소지 제자", CharacterGroup.X, 0.7),

                new Character("오티스 - LCA 우제트 선봉 3팀 팀장", CharacterGroup.XI, 0.7),

                new Character("그레고르 - 로보토미 E.G.O 램프", CharacterGroup.XII, 0.7),
                new Character("그레고르 - 밤의 송곳 카피타노", CharacterGroup.XII, 1.0)
        };
        int[] weightsBanner1 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int[] weightsBanner2 = {2,2,2,2,2,87,2,2,2,87,2,2,2,2,2,2,2,2,2,2,2};

        Banner banner1 = new Banner( // 발푸밤
                0.013,
                0.013,
                0.029,
                0.128,
                poolBanner1,
                weightsBanner2,
                false,
                0.6264,
                10,
                1
        );

        Banner banner2 = new Banner( // 일반(할인 & 천장)
                0.000,
                0.013,
                0.029,
                0.128,
                poolBanner1,
                weightsBanner1,
                true,
                0.26,
                19,
                2
        );

        Banner banner3 = new Banner( // 3성 확정
                0.000,
                0.013,
                0.029,
                0.128,
                poolBanner1,
                weightsBanner1,
                true,
                0.26,
                9,
                3
        );

        Banner banner4 = new Banner( // 일반
                0.000,
                0.013,
                0.029,
                0.128,
                poolBanner1,
                weightsBanner1,
                false,
                0.26,
                10,
                4
        );

        Banner[] banners = {banner1, banner2, banner3, banner4};

        BannerSelector selector = new BannerSelector(banners);
        SimulationRunner runner = new SimulationRunner(selector);
        runner.run(1000000, 5, 7.0);
    }
}