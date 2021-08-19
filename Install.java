package WorkerFiles;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Install {
    public static StringBuilder sBuilder = new StringBuilder ( );

    public static void main ( String[] args ) {
        createDir ( "D://Games" , "src" );
        createDir ( "D://Games" , "res" );
        createDir ( "D://Games" , "savegames" );
        createDir ( "D://Games" , "temp" );
        createDir ( "D://Games//src" , "main" );
        createDir ( "D://Games//src" , "test" );
        createDir ( "D://Games//res" , "drawables" );
        createDir ( "D://Games//res" , "vectors" );
        createDir ( "D://Games//res" , "icons" );
        createFile ( "D://Games//src//main//Main.java" );
        createFile ( "D://Games//src//main//Utils.java" );
        createFile ( "D://Games//temp//temp.txt" );

        try (BufferedWriter bufferedWriter = new BufferedWriter ( new FileWriter ( "D://Games//temp//temp.txt" ) )) {
            bufferedWriter.write ( sBuilder.toString ( ) );
        } catch (IOException e) {
            e.printStackTrace ( );
        }

        System.out.println ( sBuilder );
    }

    public static void createDir ( String parentName , String dirName ) {
        File dir = new File ( parentName , dirName );
        if ( dir.mkdir ( ) ) {
            sBuilder.append ( "Создан каталог " )
                    .append ( dirName )
                    .append ( " в каталоге " )
                    .append ( parentName )
                    .append ( "\n" );
        } else {
            sBuilder.append ( "Ошибка при создании каталога " )
                    .append ( dirName )
                    .append ( " в каталоге " )
                    .append ( parentName )
                    .append ( "\n" );
        }
    }

    public static void createFile ( String path ) {
        File file = new File ( path );
        try {
            if ( file.createNewFile ( ) ) {
                sBuilder.append ( "Создан файл " )
                        .append ( path )
                        .append ( "\n" );
            } else {
                sBuilder.append ( ": " )
                        .append ( "Ошибка при создании файла " )
                        .append ( path )
                        .append ( "\n" );
            }
        } catch (IOException e) {
            sBuilder.append ( "При создании файла " )
                    .append ( path )
                    .append ( " возникло исключение " )
                    .append ( " :\n\t" )
                    .append ( e.toString ( ) )
                    .append ( "\n" );
        }
    }
}