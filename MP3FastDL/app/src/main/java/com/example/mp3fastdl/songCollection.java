package com.example.mp3fastdl;

public class songCollection {

    public static Song[] songs = new Song[6];

    public static Song[] songs1 = new Song[10];

    public static Song[] songs2 = new Song[10];

    public static Song[] songs3 = new Song[10];

    songCollection() {
        prepareSongs();
    }

    private void prepareSongs() {

        Song TongHua = new Song("S1001", "童话", "Michael Wong", "e908ccf288c2d8f1f11bff11635d20e6493dc3e3?cid=2afe87a64b0042dabf51f37318616965", 4.10, "ab67616d0000b273bb178b1417ec83aedc0ba972");

        Song Photograph = new Song("S1002", "Photograph", "Ed Sheeran", "097c7b735ceb410943cbd507a6e1dfda272fd8a8?cid=2afe87a64b0042dabf51f37318616965", 4.32, "photograph");

        Song SomeoneYouLoved = new Song("S1003", "Someone You Loved", "Lewis Capaldi", "08c92f0dc9657fba683cb87240afe76a1b97a61e?cid=2afe87a64b0042dabf51f37318616965", 3.06, "someoneuloved");

        Song ShuoHaoBuKu = new Song("S1004", "说好不哭", "Jay Chou", "e72b922310c07063528396d411b912721eadfa67?cid=2afe87a64b0042dabf51f37318616965", 3.71, "shuohaobuku");

        Song RuGuoYuZhiHou = new Song("S1005", "如果雨之后", "Eric Chou", "a3c76f60aeeaf0d935ec4911d1d15a95967d1293?cid=2afe87a64b0042dabf51f37318616965", 4.69, "ruguoyuzhihou");

        Song BuWeiShuiErZuoDeGe = new Song("S1006", "不为谁而作的歌", "JJ Lin", "b0f9658eab76e1409678f9e6b0c916f8099271c5?cid=2afe87a64b0042dabf51f37318616965", 4.43, "ab67616d0000b27328c8c2fcc98775c7ea48b81c");

        Song Beautifulpeople = new Song("imageView33", "Beautiful People", "Ed Sheeran", "3ad904af9567a7c7df7d23a8d6700296ded34b4f?cid=2afe87a64b0042dabf51f37318616965", 3.30, "ab67616d0000b2737ed2a6d678a53a5959b2894f");

        Song castleonthehill = new Song("imageView32", "Castle On The Hill", "Ed Sheeran", "beb4ed48cca5d2a792e877c7efe92d54046eac67?cid=2afe87a64b0042dabf51f37318616965", 4.35, "ab67616d0000b273ba5db46f4b838ef6027e6f96");

        Song imyours = new Song("imageView35", "I'm Yours", "Jason Mraz", "c58f1bc9160754337b858a4eb824a6ac2321041d?cid=2afe87a64b0042dabf51f37318616965", 4.04, "ab67616d0000b273160074c4d30216702688437c");

        Song RuGuoYuZhiHou2 = new Song("imageView52", "如果雨之后", "Eric Chou", "a3c76f60aeeaf0d935ec4911d1d15a95967d1293?cid=2afe87a64b0042dabf51f37318616965", 4.69, "ruguoyuzhihou");

        Song Donttouchmytruck = new Song("imageView34", "Don't Touch My Truck", "Tik Tok", "5cac92d7cf9886deb27e547971b6b064a653acbd?cid=2afe87a64b0042dabf51f37318616965", 2.61, "ab67616d0000b27326c25bf32ac8dcf755e00e8c");

        Song xiulianaiqin = new Song("imageView36", "修炼爱情", "JJ Lin", "5f3bcaacc2028bc9f3cb1cf5b41629abce74111f?cid=2afe87a64b0042dabf51f37318616965", 4.78, "ab67616d0000b273352fb54206892599dcfbc792");

        Song diyici = new Song("imageView37", "第一次", "Michael Wong", "acd8228e930cb4fb5a60ba62c7238c97447907f0?cid=2afe87a64b0042dabf51f37318616965", 4.39, "ab67616d0000b273bb178b1417ec83aedc0ba972");

        Song rollinginthedeep = new Song("imageView39", "Rolling In The Deep","Adele", "8c174ce25d94b502dfe31f0da8a070a32fb263db?cid=2afe87a64b0042dabf51f37318616965", 3.80, "ab67616d0000b2736d4056466fc11f6408be2566");

        Song superpower = new Song("imageView38", "Superpower","Adam Lambert", "4300c7677b98328a464fc811cd3084d3cab87661?cid=2afe87a64b0042dabf51f37318616965", 3.17, "ab67616d0000b273e8523e7781cf313fc080da5c");

        Song highhopes = new Song("imageView40", "High Hopes","Panic! At The Disco", "f6404b1b3199442271c17d9e1461c3f2a52018f8?cid=2afe87a64b0042dabf51f37318616965", 3.18, "ab67616d0000b273c5148520a59be191eea16989");

        Song dragmedown = new Song("imageView51", "Drag Me Down","One Direction", "09a6fcd9ca6aac808bf9ab042a55ca9ea63d66d0?cid=2afe87a64b0042dabf51f37318616965", 3.20, "ab67616d0000b273241e4fe75732c9c4b49b94c3");

        Song bestsongever = new Song("imageView42", "Best Song Ever","One Direction", "5e4931ee7653a4f078e1734c64daa14bd4262054?cid=2afe87a64b0042dabf51f37318616965", 3.34, "bestsongever");

        Song storyofmylife = new Song("imageView43", "Story Of My Life","One Direction", "e8cbef539a2a32def5e66968cc00769a4f523c1c?cid=2afe87a64b0042dabf51f37318616965", 4.09, "storyofmylife");

        Song midnightmemories = new Song("imageView44", "Midnight Memories","One Direction", "8c6d5d7d58c717a9c81d24568b0f13b83f022aa7?cid=2afe87a64b0042dabf51f37318616965", 3.34, "midnightmemories");

        Song youni = new Song("imageView45", "You And I","One Direction", "0e98fb1c291a454abde0ea94c4e97195705b2a23?cid=2afe87a64b0042dabf51f37318616965", 3.97, "youni");

        Song perfect = new Song("imageView46", "Perfect","One Direction", "c6272bcc7ec076e8ef127a4ae95aca99aa3728ed?cid=2afe87a64b0042dabf51f37318616965", 3.84, "perfect");

        Song whatmakesyoubeautiful = new Song("imageView47", "What Makes You Beautiful","One Direction", "170a9a5c3c9d418b8a3027ef538dd34b3291dfeb?cid=2afe87a64b0042dabf51f37318616965", 3.33, "whatmakesubeautiful");

        Song livewhileweareyoung = new Song("imageView48", "Live While We Are Young","One Direction", "2d7e502cfbccd748e5c4b0d032e775ecca4ed721?cid=2afe87a64b0042dabf51f37318616965", 3.34, "livewhileweareyoung");

        Song onething = new Song("imageView49", "One Thing","One Direction", "f211f125292ebc47b63b3112b8869c9c6089392e?cid=2afe87a64b0042dabf51f37318616965", 3.29, "onething");

        Song stealmygirl = new Song("imageView50", "Steal My Girl","One Direction", "2be03a39526b79e665a488afb5f87257a7977dce?cid=2afe87a64b0042dabf51f37318616965", 3.80, "stealmygirl");

        Song teenagedream = new Song("imageView41", "Teenage Dream","Wen Wei", "b174088807a341e4991061a39ca7cd964dcea1fe?cid=2afe87a64b0042dabf51f37318616965", 3.20, "teenagedreams");

        Song tashuo = new Song("imageView53", "她说","JJ Lin", "c2b951a9e420f3aa614ffb69a299850c53e1f031?cid=2afe87a64b0042dabf51f37318616965", 5.31, "tashuo");

        Song yhbzpy = new Song("imageView54", "以后别做朋友","Eric Chou", "b1430895bcc5aa5b96db94e617122a5a87a45c7a?cid=2afe87a64b0042dabf51f37318616965", 4.34, "yhbzpy");

        Song zenmele = new Song("imageView55", "怎么了","Eric Chou", "a1d5aa55e834c8b38227c4969579c718cb36187e?cid=2afe87a64b0042dabf51f37318616965", 5.35, "zhenmele");

        Song qcxlsc = new Song("imageView56", "青春修煉手冊","TF Boys", "547896e827892e0622fe66ba8c6770d878bf3fca?cid=2afe87a64b0042dabf51f37318616965", 4.38, "qcxlsc");

        Song mfdcb = new Song("imageView57", "魔法城堡","TF Boys", "c2471d5604af6c6124c041bd1a4d0e526d8595b9?cid=2afe87a64b0042dabf51f37318616965", 4.29, "mfdcb");

        Song szx = new Song("imageView58", "手掌心","Della", "c1374b75342020cd2474da9218aa800a6f8739f2?cid=2afe87a64b0042dabf51f37318616965", 4.26, "szx");

        Song rgwmbcxy = new Song("imageView59", "如果我們不曾相遇","Mayday", "6a364d5d30b4c9f0c4c283d667d482ae688e71a6?cid=2afe87a64b0042dabf51f37318616965", 3.37, "rgwmbcxy");

        Song touming = new Song("imageView60", "透明","G.E.M.", "9a5f55377f24148bec4922ad3a9a3e30eef6f65d?cid=2afe87a64b0042dabf51f37318616965", 3.62, "touming");

        Song anjing = new Song("imageView61", "安靜","Jay Chou", "b94e5c5584ab4faa17b7913575a6db154ed7f308?cid=2afe87a64b0042dabf51f37318616965", 5.57, "anjing");

        songs[0] = TongHua;
        songs[1] = Photograph;
        songs[2] = SomeoneYouLoved;
        songs[3] = ShuoHaoBuKu;
        songs[4] = RuGuoYuZhiHou;
        songs[5] = BuWeiShuiErZuoDeGe;

        songs1[0] = imyours;
        songs1[1] = castleonthehill;
        songs1[2] = Beautifulpeople;
        songs1[3] = xiulianaiqin;
        songs1[4] = Donttouchmytruck;
        songs1[5] = diyici;
        songs1[6] = rollinginthedeep;
        songs1[7] = superpower;
        songs1[8] = highhopes;
        songs1[9] = teenagedream;

        songs2[0] = bestsongever;
        songs2[1] = storyofmylife;
        songs2[2] = midnightmemories;
        songs2[3] = youni;
        songs2[4] = perfect;
        songs2[5] = whatmakesyoubeautiful;
        songs2[6] = livewhileweareyoung;
        songs2[7] = onething;
        songs2[8] = stealmygirl;
        songs2[9] = dragmedown;

        songs3[0] = RuGuoYuZhiHou2;
        songs3[1] = tashuo;
        songs3[2] = yhbzpy;
        songs3[3] = zenmele;
        songs3[4] = qcxlsc;
        songs3[5] = mfdcb;
        songs3[6] = szx;
        songs3[7] = rgwmbcxy;
        songs3[8] = touming;
        songs3[9] = anjing;
    }

    public static Song searchByID(String id) {
        Song tempSong = null;
        for (int i = 0; i < songs.length; i++) {
            tempSong = songs[i];
            String tempID = tempSong.getId();
            if (tempID.equals(id)) {
                return tempSong;
            }

        }
        return tempSong;
    }

    public static Song searchByID2(String id) {
        Song tempSong = null;
        for (int i = 0; i < songs1.length; i++) {
            tempSong = songs1[i];
            String tempID = tempSong.getId();
            if (tempID.equals(id)) {
                return tempSong;
            }

        }
        return tempSong;
    }

    public static Song searchByID3(String id) {
        Song tempSong = null;
        for (int i = 0; i < songs2.length; i++) {
            tempSong = songs2[i];
            String tempID = tempSong.getId();
            if (tempID.equals(id)) {
                return tempSong;
            }

        }
        return tempSong;
    }

    public static Song searchByID4(String id) {
        Song tempSong = null;
        for (int i = 0; i < songs3.length; i++) {
            tempSong = songs3[i];
            String tempID = tempSong.getId();
            if (tempID.equals(id)) {
                return tempSong;
            }

        }
        return tempSong;
    }

    public static Song getNextSong(String currentSongId) {
        Song song = null;
        for (int index = 0; index < songs.length; index++) {
            String tempSongId = songs[index].getId();
            if (tempSongId.equals(currentSongId) && (index < songs.length - 1)) {
                song = songs[index + 1];
                break;
            }
        }
        for (int index = 0; index < songs1.length; index++) {
            String tempSongId = songs1[index].getId();
            if (tempSongId.equals(currentSongId) && (index < songs1.length - 1)) {
                song = songs1[index + 1];
                break;
            }
        }
        for (int index = 0; index < songs2.length; index++) {
            String tempSongId = songs2[index].getId();
            if (tempSongId.equals(currentSongId) && (index < songs2.length - 1)) {
                song = songs2[index + 1];
                break;
            }
        }
        for (int index = 0; index < songs3.length; index++) {
            String tempSongId = songs3[index].getId();
            if (tempSongId.equals(currentSongId) && (index < songs3.length - 1)) {
                song = songs3[index + 1];
                break;
            }
        }
        return song;
    }

    public static Song getPrevSong(String currentSongId) {
        Song song = null;
        for (int index = 0; index < songs.length; index++) {
            String tempSongId = songs[index].getId();
            if (tempSongId.equals(currentSongId) && (index > 0)) {
                song = songs[index - 1];
                break;
            }
        }
        for (int index = 0; index < songs1.length; index++) {
            String tempSongId = songs1[index].getId();
            if (tempSongId.equals(currentSongId) && (index > 0)) {
                song = songs1[index - 1];
                break;
            }
        }
        for (int index = 0; index < songs2.length; index++) {
            String tempSongId = songs2[index].getId();
            if (tempSongId.equals(currentSongId) && (index > 0)) {
                song = songs2[index - 1];
                break;
            }
        }
        for (int index = 0; index < songs3.length; index++) {
            String tempSongId = songs3[index].getId();
            if (tempSongId.equals(currentSongId) && (index > 0)) {
                song = songs3[index - 1];
                break;
            }
        }
        return song;
    }
}
