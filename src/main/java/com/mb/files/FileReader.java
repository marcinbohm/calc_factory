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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class FileReader {

    public static Collection<Pair<String, Integer>> getOperatorsWithValuesFromFile() {

        List<Pair<String, Integer>> operatorValueCollection = new LinkedList<>();
        Path filePath = Paths.get(Globals.FROM_PATH, Globals.FROM_FILENAME);

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineStringTable = line.trim().split("\\s+");
                if (lineStringTable.length == 2) {
                    String operatorName = lineStringTable[0];
                    String operatorValueString = lineStringTable[1];
                    if (NumericUtil.isNumeric(operatorValueString)) {
                        int operatorValue = Integer.parseInt(operatorValueString);
                        operatorValueCollection.add(new Pair<>(operatorName, operatorValue));
                        if (OperatorsEnum.APPLY.getName().equals(operatorName)) {
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new FailureException("There was a problem with reading file from configured path!");
        } catch (NumberFormatException e) {
            throw new FailureException("Not proper format of expression provided in file to read!");
        }

        if (operatorValueCollection.isEmpty()) {
            throw new FailureException("Can't operate on empty operator list! Enter proper values to file!");
        }

        return operatorValueCollection;
    }
}
