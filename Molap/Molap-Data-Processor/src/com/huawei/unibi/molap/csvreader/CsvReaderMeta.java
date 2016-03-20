/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


package com.huawei.unibi.molap.csvreader;

import java.util.Map;

import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.trans.step.StepDataInterface;
import org.pentaho.di.trans.step.StepInterface;
import org.pentaho.di.trans.step.StepMeta;
import org.pentaho.di.trans.steps.csvinput.CsvInputMeta;

import com.huawei.iweb.platform.logging.LogService;
import com.huawei.iweb.platform.logging.LogServiceFactory;
import com.huawei.unibi.molap.csvreader.checkpoint.CheckPointHanlder;
import com.huawei.unibi.molap.csvreader.checkpoint.CheckPointInterface;
import com.huawei.unibi.molap.csvreader.checkpoint.exception.CheckPointException;
import com.huawei.unibi.molap.util.MolapDataProcessorLogEvent;

/**
 * 
 * Project Name NSE V3R7C00 
 * Module Name : Molap Data Processor 
 * Author K00900841
 * Created Date :21-May-2013 6:42:29 PM 
 * FileName :CsvReaderMeta.java 
 * Class Description :CsvReaderMeta 
 * Version 1.0
 */
public class CsvReaderMeta extends CsvInputMeta
{
    
    /**
     * LOGGER
     */
    private static final LogService LOGGER = LogServiceFactory
            .getLogService(CsvReaderMeta.class.getName());
    
    /**
     * checkpoint
     */
    private CheckPointInterface checkpoint;
    
    /**
     * fileNameOffSetCache
     */
    private Map<String,Long> fileNameOffSetCache;
    
    /**
     * Below method will be used to get the check point 
     * @return
     */
    public CheckPointInterface getCheckpoint()
    {
        return checkpoint;
    }

    /**
     * Below method will be used to set the checkpoint 
     * @param checkpoint
     */
    public void setCheckpoint(CheckPointInterface checkpoint)
    {
        this.checkpoint = checkpoint;
    }
    
    /**
     * Get the executing step, needed by Trans to launch a step.
     * 
     * @param stepMeta
     *            The step info
     * @param stepDataInterface
     *            the step data interface linked to this step. Here the step can
     *            store temporary data, database connections, etc.
     * @param copyNr
     *            The copy nr to get
     * @param transMeta
     *            The transformation info
     * @param trans
     *            The launching transformation
     */
    public StepInterface getStep(StepMeta stepMeta,
            StepDataInterface stepDataInterface, int cnr, TransMeta tr,
            Trans trans)
    {
        return new CsvReader(stepMeta, stepDataInterface, cnr, tr, trans);
    }
    
    /**
     * Get a new instance of the appropriate data class. This data class
     * implements the StepDataInterface. It basically contains the persisting
     * data that needs to live on, even if a worker thread is terminated.
     * 
     * @return The appropriate StepDataInterface class.
     */
    public StepDataInterface getStepData()
    {
        return new CsvReaderData();
    }

    /**
     * Below method will be used to initialise the check point 
     * @param transPath
     */
    public void initializeCheckPoint(String transPath)
    {
        CheckPointInterface checkpoint = CheckPointHanlder
                .getCheckpoint(transPath);
        try
        {
            this.fileNameOffSetCache=checkpoint.getCheckPointCache();
        }
        catch(CheckPointException e)
        {
            LOGGER.error(
                    MolapDataProcessorLogEvent.UNIBI_MOLAPDATAPROCESSOR_MSG,
                    "Problem while getting the check point");
        }
    }

    /**
     * @return the fileNameOffSetCache
     */
    public Map<String, Long> getFileNameOffSetCache()
    {
        return fileNameOffSetCache;
    }

    /**
     * @param fileNameOffSetCache the fileNameOffSetCache to set
     */
    public void setFileNameOffSetCache(Map<String, Long> fileNameOffSetCache)
    {
        this.fileNameOffSetCache = fileNameOffSetCache;
    }
    
}
