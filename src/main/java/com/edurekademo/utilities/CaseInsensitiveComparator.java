package com.edurekademo.utilities;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CaseInsensitiveComparator extends GenericComparator {

        private static final long serialVersionUID = -6836701171640412573L;
        private static final Logger LOG =LoggerFactory.getLogger(CaseInsensitiveComparator.class); 

        /*
         * This function call base GenericComparator(boolean sortAscending) class and set whether sorting is in ascending or descending
         * sortAscending = true then ascending
         * sortAscending = false then descending
         */
        public CaseInsensitiveComparator(boolean sortAscending) {
                super(sortAscending);
                this.targetMethod = null;
                this.sortAscending = sortAscending;
        }
        /*
         * This function call base GenericComparator(boolean sortField) class and set which field we need to sort and sort as asc
         */
        public CaseInsensitiveComparator(String sortField) {
                super(sortField);
                this.targetMethod = prepareTargetMethod(sortField);
                this.sortAscending = true;
        }
        /*
         * This function call base GenericComparator(boolean sortField,sortAscending) class and set which field we need to sort and sort based on the boolen value given
         * sortAscending = true then ascending
         * sortAscending = false then descending
         */
        public CaseInsensitiveComparator(String sortField, boolean sortAscending) {
                super(sortField, sortAscending);
                this.targetMethod = prepareTargetMethod(sortField);
                this.sortAscending = sortAscending;
        }

        /*
         * (non-Javadoc)
         * @see com.edurekademo.utilities.GenericComparator#compare(java.lang.Object, java.lang.Object)
         */
        public int compare(Object o1, Object o2) {
                int response = LESSER;
                Object v1,v2;
                String returnType;
                try {
                        if(this.targetMethod==null){
                                v1=o1;
                                v2=02;
                                returnType=o1.getClass().getName();
                        }else{
                                v1=getValue(o1);
                                v2=getValue(o2);
                                returnType=getMethod(o1).getReturnType().getName();
                        }
                        
                        CompareMode cm = findCompareMode(v1, v2);
                        if (!cm.equals(CompareMode.DEFAULT)) {
                                return compareAlternate(cm);
                        }
                        response = compareActual(v1, v2, returnType);
                } 
                catch (NoSuchMethodException e){LOG.error(new LoggerStackTraceUtil().getErrorMessage(e));} 
                catch (IllegalAccessException e){LOG.error(new LoggerStackTraceUtil().getErrorMessage(e));} 
                catch (InvocationTargetException e){LOG.error(new LoggerStackTraceUtil().getErrorMessage(e));} 
                return response;
        }
        /*
         * This Method is the overridden compareActual of GenericComparator. 
         * If the data type is String then it convert string to upper case and compare it with other.
         */
        protected int compareActual(Object v1, Object v2, String returnType) {
                String obj = returnType;
                if ("java.lang.Object".equals(obj) && v1!=null) { 
                        obj = v1.getClass().getName(); 
                }
                int acutal = LESSER; 
                if (obj.equals(DATATYPE_INTEGER)) {
                        acutal = ((Integer) v1).compareTo((Integer) v2) * determinePosition();
                } else if (obj.equals(DATATYPE_LONG)) {
                        acutal = ((Long) v1).compareTo((Long) v2) * determinePosition();
                } else if (obj.equals(DATATYPE_STRING)) {
                        acutal = ((String) v1).toUpperCase().compareTo(((String) v2).toUpperCase()) * determinePosition();
                } else if (obj.equals(DATATYPE_DATE)) {
                        acutal = ((Date) v1).compareTo((Date) v2) * determinePosition();
                } else if (obj.equals(DATATYPE_FLOAT)) {
                        acutal = ((Float) v1).compareTo((Float) v2) * determinePosition();
                } else if (obj.equals(DATATYPE_DOUBLE)) {
                        acutal = ((Double) v1).compareTo((Double) v2) * determinePosition();
                }
                return acutal;
        }

}
