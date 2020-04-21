import java.io.*;

class TD78 {

    private static File compresserBlancs(File f) throws IOException {
        /* Creating file to compress and its writer and reader*/
        File compressed = new File("/home/zahrof/Documents/master/semestre2/Genitrini-Part/Files/SuppressionDesBlancsCompresse.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        BufferedWriter bw = new BufferedWriter(new FileWriter(compressed));

        /* Reading from file */

        String st;
        while ((st = br.readLine()) != null) {
            int spaces = 0;
            for (int i = 0; i < st.length(); i++) {
                if (st.charAt(i) == ' ') {
                    while (st.charAt(i) == ' ') {
                        spaces++;
                        if (st.charAt(i + 1) != ' ' && ((i + 1) < st.length())) {
                            break;
                        }
                        i++;
                    }
                    bw.write("#" + spaces);
                    System.out.print("#" + spaces);
                    spaces = 0;
                } else {
                    System.out.print(st.charAt(i));
                    bw.write(st.charAt(i));
                }
            }
            System.out.print("\n");
            bw.write("\n");
        }
        bw.close();
        return compressed;
    }

    private static File decompresserBlancs(File f) throws IOException {
        File decompressed = new File("/home/zahrof/Documents/master/semestre2/Genitrini-Part/Files/SuppressionDesBlancsDecompresse.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        BufferedWriter bw = new BufferedWriter(new FileWriter(decompressed));

        /* Reading from file */
        String st;
        while ((st = br.readLine()) != null){
            for (int i = 0; i < st.length(); i++){
                if(st.charAt(i)=='#') {
                    int j = Character.getNumericValue(st.charAt(i+1));
                    while ( j > 0) {
                        System.out.print(" ");
                        bw.write(" ");
                        j--;
                    }
                    i++;
                }
                else {
                    System.out.print(st.charAt(i));
                    bw.write(st.charAt(i));
                }
            }
            System.out.print("\n");
            bw.write("\n");
        }
        bw.close();
        return decompressed;
    }

    private static File compresserRep(File f) throws IOException {
        /* Creating file to compress and its writer and reader*/
        File compressed = new File("/home/zahrof/Documents/master/semestre2/Genitrini-Part/Files/RepetitionsCompresse.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        BufferedWriter bw = new BufferedWriter(new FileWriter(compressed));

        /* Reading from file */

        String st;
        while ((st = br.readLine()) != null) {
            int rep = 1;
            for (int i = 0; i < st.length(); i++) {
                if(((i + 1) < st.length())&&(st.charAt(i + 1) == st.charAt(i))) {

                        while (st.charAt(i + 1) == st.charAt(i)) {
                            rep++;
                            if (st.charAt(i + 1) != st.charAt(i) && ((i + 1) < st.length())) {
                                break;
                            }
                            i++;
                        }
                        bw.write("#" + rep + st.charAt(i));
                        System.out.print("#" + rep);
                        rep = 1;

                }else {
                    System.out.print(st.charAt(i));
                    bw.write(st.charAt(i));
                }
            }
            System.out.print("\n");
            bw.write("\n");
        }
        bw.close();
        return compressed;
    }

    private static File decompresserRep(File f) throws IOException {
        /* Creating file to compress and its writer and reader*/
        File decompressed = new File("/home/zahrof/Documents/master/semestre2/Genitrini-Part/Files/RepetitionsDecompresse.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        BufferedWriter bw = new BufferedWriter(new FileWriter(decompressed));

        /* Reading from file */

        String st;
        while ((st = br.readLine()) != null) {
            int rep = 1;
            for (int i = 0; i < st.length(); i++) {
                if(st.charAt(i)=='#') {

                    int j = Character.getNumericValue(st.charAt(i+1));
                    while ( j > 0) {
                        System.out.print(" ");
                        bw.write(st.charAt(i+2));
                        j--;
                    }
                    i=i+2;

                }else {
                    System.out.print(st.charAt(i));
                    bw.write(st.charAt(i));
                }
            }
            System.out.print("\n");
            bw.write("\n");
        }
        bw.close();
        return decompressed;
    }

    public static void main(String[] args) throws IOException {
        File file = new File (args[0]);
        File compresse = compresserBlancs(file);
        decompresserBlancs(compresse);

    }



}