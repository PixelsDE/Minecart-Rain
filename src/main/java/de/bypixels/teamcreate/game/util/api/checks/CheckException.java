package de.bypixels.teamcreate.game.util.api.checks;

/******************************************************************
 *   Copyright Notice                                             * 
 *   Copyright (c) PixelsDE | Daniel 2018                         *                       
 *   Created: 08.05.2018 / 15:13                                  *
 *   All contents of this source text are protected by copyright. * 
 *   The copyright law, unless expressly indicated otherwise, is  * 
 *   at PixelsDE | Daniel. All rights reserved                    *
 *   Any type of duplication, distribution, rental, sale, award,  *
 *   Public accessibility or other use                            * 
 *   Requires the express written consent of PixelsDE | Daniel.   *
 *****************************************************************/
public class CheckException extends Exception {

    private boolean checkResult;
    private Object checkObject1;
    private Object checkObject2;
    private String exceptionString;


    public CheckException(String exceptionString, Object checkObject1, Object checkObject2) {
        super(exceptionString);
        this.exceptionString = exceptionString;
        this.checkObject1 = checkObject1;
        this.checkObject2 = checkObject2;
    }

    public void equals() throws CheckException {
        if (checkObject1 == checkObject2) {
            setCheckResult(true);
        } else {
            setCheckResult(false);
            throw new CheckException(getExceptionString());
        }
    }

    public void unequals() throws CheckException {
        if (checkObject1 != checkObject2) {
            setCheckResult(true);
        } else {
            setCheckResult(false);
            throw new CheckException(getExceptionString());
        }
    }

    public void higher() throws CheckException {
        if ((int) checkObject1 > (int) checkObject2) {
            setCheckResult(true);
        } else {
            setCheckResult(false);
            throw new CheckException(getExceptionString());
        }
    }

    public void lower() throws CheckException {
        if ((int) checkObject1 < (int) checkObject2) {
            setCheckResult(true);
        } else {
            setCheckResult(false);
            throw new CheckException(getExceptionString());
        }
    }

    private CheckException(String exceptionString) {
        this.exceptionString = exceptionString;
    }


    public String getExceptionString() {
        return exceptionString;
    }

    public void setExceptionString(String exceptionString) {
        this.exceptionString = exceptionString;
    }

    public boolean isCheckResult() {
        return checkResult;
    }

    public void setCheckResult(boolean checkResult) {
        this.checkResult = checkResult;
    }

    public Object getCheckObject1() {
        return checkObject1;
    }

    public void setCheckObject1(Object checkObject1) {
        this.checkObject1 = checkObject1;
    }

    public Object getCheckObject2() {
        return checkObject2;
    }

    public void setCheckObject2(Object checkObject2) {
        this.checkObject2 = checkObject2;
    }
}
