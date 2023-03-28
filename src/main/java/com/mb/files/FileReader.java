package com.mb.files;

import com.mb.Globals;
import com.mb.OperatorsEnum;
import com.mb.Pair;
import com.mb.exception.FailureException;
import com.mb.util.NumericUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedList;

public class FileReader {

    public static Collection<Pair<String, Integer>> getOperatorsWithValuesFromFile() {

        LinkedList<Pair<String, Integer>> operatorValueCollection = new LinkedList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(Globals.FROM_PATH + File.separator + Globals.FROM_FILENAME))) {
            while (reader.ready()) {
                String[] lineStringTable = reader.readLine().split("\\s+");
                if (lineStringTable[0] != null
                        && lineStringTable[1] != null
                        && NumericUtil.isNumeric(lineStringTable[1])
                        && lineStringTable.length == 2) {
                    operatorValueCollection.add(new Pair<>(lineStringTable[0], Integer.parseInt(lineStringTable[1])));
                    if (lineStringTable[0].trim().equals(OperatorsEnum.APPLY.getName()))
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("There was a problem with reading file from configured path!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not proper format of expression provided in file to read!");
        }

        if (operatorValueCollection.isEmpty())
            throw new FailureException("Can't operate on empty operator list! Enter proper values to file!");

        return operatorValueCollection;
    }
}
