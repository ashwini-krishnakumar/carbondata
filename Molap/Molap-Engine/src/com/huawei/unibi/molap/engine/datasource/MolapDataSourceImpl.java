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

package com.huawei.unibi.molap.engine.datasource;

//import org.apache.log4j.Logger;

/**
 *
 * Class Description : This class will be used for getting the molap data source
 * 
 * Version 1.0
 */
public class MolapDataSourceImpl //extends AbstractMolapDataSource
{

//    /**
//     * LOGGER
//     */
//    private static final LogService LOGGER = LogServiceFactory.getLogService(MolapDataSourceImpl.class.getName());
//
//    /**
//     * connection url
//     */
//    private String url;
//
//    /**
//     * persistent store path
//     */
//    private String fileStore = null;
//
//    /**
//     * username
//     */
//    private String user;
//
//    /**
//     * password
//     */
//    private String password;
//
//    /**
//     * driverName
//     */
//    private String driverName;
//
//    /**
//     * MolapDataSource constructor It will get all the connection information
//     * from connectInfo and initialize lcal variables
//     * 
//     * @param connectInfo
//     *            conection details properties
//     */
//    public MolapDataSourceImpl(Util.PropertyList connectInfo)
//    {
//        // get the url
//        url = connectInfo.get(RolapConnectionProperties.Jdbc.name());
//
//        // sample
//        // url-file:///home/specificationPersistentStore;jdbc:mysql://localhost:3306/specificationDB
//        if(url.startsWith("file:///"))
//        {
//            String[] temp = url.split(";");
//
//            // first part will be file store path
//            fileStore = temp[0].substring("file:///".length() - 1);
//            String tempURL = temp.length > 1 ? temp[1] : "";
//            url = "".equals(tempURL.trim()) ? null : temp[1];
//        }
//
//        // get the username
//        user = connectInfo.get(RolapConnectionProperties.JdbcUser.name());
//        // get the password
//        password = connectInfo.get(RolapConnectionProperties.JdbcPassword.name());
//        // get the driver class name
//        driverName = connectInfo.get(RolapConnectionProperties.JdbcDrivers.name());
//
//    }
//
//    
//    /**
//     * Set the connection URL
//     * 
//     * @param url
//     *            String url
//     * 
//     */
//    public void setUrl(String url)
//    {
//        this.url = url;
//    }
//
//    /**
//     * Enable cache or not @
//     * 
//     */
//    public boolean isEnableCache()
//    {
//        // TODO Auto-generated method stub
//        return true;
//    }
//
//    /**
//     * Returns the driver name
//     * 
//     * @return driver name
//     * 
//     */
//    public String getDriverName()
//    {
//        return driverName;
//    }
//
//    /**
//     * Returns the URL
//     * 
//     * @return url
//     * 
//     */
//    public String getURL()
//    {
//        return url;
//    }
//
//    /**
//     * 
//     * Returns the Persistent store path
//     * 
//     * @return persistent store path
//     * 
//     */
//    public String getFileStore()
//    {
//        return fileStore;
//    }
//
//    /**
//     * It returns the drill through MOLAP query
//     */
//    @Override
//    public String getMolapQuery(DrillThroughQuerySpec spec)
//    {
//        MolapStatement statement = new MolapStatement(this);
//        return statement.getMolapQuery(spec);
//    }
//    
//    /**
//     * getDrillThroughCount
//     * @param spec
//     * @return int
//     */
//    public int getDrillThroughCount(DrillThroughQuerySpec spec)
//    {
//        MolapStatement statement = new MolapStatement(this);
//       MolapResultHolder rs = statement.executeQuery(statement.getMolapQuery(spec));
//       int count = -1;
//       if(rs.isNext())
//       {
//           count = ((Double)rs.getObject(1)).intValue();
//       }
//       return count;
//    }
//
//
//    public Logger getParentLogger() throws SQLFeatureNotSupportedException
//    {
//        // TODO Auto-generated method stub
//        return null;
//    }

}
