/*
 * file:       ResourceAssignment.java
 * author:     Scott Melville
 *             Jon Iles
 * copyright:  (c) Tapster Rock Limited 2002-2003
 * date:       15/08/2002
 */

/*
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation; either version 2.1 of the License, or (at your
 * option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */

package com.tapsterrock.mpx;

import java.util.Date;

/**
 * This class represents a resource assignment record from an MPX file.
 */
public class ResourceAssignment extends MPXRecord
{
   /**
    * Default constructor.
    *
    * @param file the parent file to which this record belongs.
    */
   ResourceAssignment (MPXFile file, Task task)
      throws MPXException
   {
      this (file, Record.EMPTY_RECORD, task);
   }

   /**
    * Constructor used to create an instance of this class from data
    * taken from an MPXFile record.
    *
    * @param file the MPXFile object to which this record belongs.
    * @param record record containing the data for  this object.
    */
   ResourceAssignment (MPXFile file, Record record, Task task)
      throws MPXException
   {
      super (file, MAX_FIELDS);

      m_task = task;

      setResourceID(record.getInteger(0));
      setUnits(record.getUnits(1));
      setWork(record.getDuration(2));
      setPlannedWork(record.getDuration(3));
      setActualWork(record.getDuration(4));
      setOvertimeWork(record.getDuration(5));
      setCost(record.getCurrency(6));
      setPlannedCost(record.getCurrency(7));
      setActualCost(record.getCurrency(8));
      setStart(record.getDate(9));
      setFinish(record.getDate(10));
      setDelay(record.getDuration(11));
      setResourceUniqueID(record.getInteger(12));
   }

   /**
    * This method allows a resource assignment workgroup fields record
    * to be added to the current resource assignment. A maximum of
    * one of these records can be added to a resource assignment record.
    *
    * @return ResourceAssignmentWorkgroupFields object
    * @throws MPXException if MSP defined limit of 1 is exceeded
    */
   public ResourceAssignmentWorkgroupFields addWorkgroupAssignment ()
      throws MPXException
   {
      if (m_workgroup != null)
      {
         throw new MPXException (MPXException.MAXIMUM_RECORDS);
      }

      m_workgroup = new ResourceAssignmentWorkgroupFields (getParentFile());

      return (m_workgroup);
   }

   /**
    * This method allows a resource assignment workgroup fields record
    * to be added to the current resource assignment. A maximum of
    * one of these records can be added to a resource assignment record.
    * The data for this new record is taken from a record read from an
    * MPX file.
    *
    * @param record record from an MPX file
    * @return ResourceAssignmentWorkgroupFields object
    * @throws MPXException if MSP defined limit of 1 is exceeded
    */
   ResourceAssignmentWorkgroupFields addWorkgroupAssignment (Record record)
      throws MPXException
   {
      if (m_workgroup != null)
      {
         throw new MPXException (MPXException.MAXIMUM_RECORDS);
      }

      m_workgroup = new ResourceAssignmentWorkgroupFields (getParentFile(), record);

      return (m_workgroup);
   }


   /**
    * Returns the resource ID associated with this assignment.
    *
    * @return ID
    */
   public int getResourceIDValue ()
   {
      return (getIntValue(RESOURCE_ID));
   }

   /**
    * Returns the resource ID associated with this assignment.
    *
    * @return ID
    */
   public Integer getResourceID ()
   {
      return ((Integer)get (RESOURCE_ID));
   }

   /**
    * Sets the resource ID associated with this assignment.
    *
    * @param val  ID
    */
   public void setResourceID (int val)
   {
      put (RESOURCE_ID, val);
   }

   /**
    * Sets the resource ID associated with this assignment.
    *
    * @param val  ID
    */
   public void setResourceID (Integer val)
   {
      put (RESOURCE_ID, val);
   }

   /**
    * Returns the units of this resource assignment
    *
    * @return units
    * @see #UNITS CONSTANTS for description
    */
   public Number getUnits ()
   {
      return ((Number)get(UNITS));
   }

   /**
    * Sets the units for this resource assignment
    *
    * @param val units
    * @see #UNITS CONSTANTS for description
    */
   public void setUnits (Number val)
   {
      putUnits (UNITS, val);
   }

   /**
    * Returns the work of this resource assignment
    *
    * @return work
    * @see #WORK CONSTANTS for description
    */
   public MPXDuration getWork ()
   {
      return ((MPXDuration)get(WORK));
   }

   /**
    * Sets the work for this resource assignment
    *
    * @param dur work
    * @see #WORK CONSTANTS for description
    */
   public void setWork (MPXDuration dur)
   {
      put (WORK, dur);
   }

   /**
    * Returns the planned work of this resource assignment
    *
    * @return planned work
    * @see #PLANNED_WORK CONSTANTS for description
    */
   public MPXDuration getPlannedWork ()
   {
      return ((MPXDuration)get(PLANNED_WORK));
   }

   /**
    * Sets the planned work for this resource assignment
    *
    * @param dur planned work
    * @see #PLANNED_WORK CONSTANTS for description
    */
   public void setPlannedWork (MPXDuration dur)
   {
      put (PLANNED_WORK, dur);
   }

   /**
    * Returns the actual completed work of this resource assignment
    *
    * @return completed work
    * @see #ACTUAL_WORK CONSTANTS for description
    */
   public MPXDuration getActualWork ()
   {
      return ((MPXDuration)get(ACTUAL_WORK));
   }

   /**
    * Sets the actual completed work for this resource assignment
    *
    * @param dur actual completed work
    * @see #ACTUAL_WORK CONSTANTS for description
    */
   public void setActualWork (MPXDuration dur)
   {
      put (ACTUAL_WORK, dur);
   }

   /**
    * Returns the overtime work done of this resource assignment
    * @return overtime work
    * @see #OVERTIME_WORK CONSTANTS for description
    */
   public MPXDuration getOvertimeWork ()
   {
      return ((MPXDuration)get(OVERTIME_WORK));
   }

   /**
    * Sets the overtime work for this resource assignment
    *
    * @param dur overtime work
    * @see #OVERTIME_WORK CONSTANTS for description
    */
   public void setOvertimeWork (MPXDuration dur)
   {
      put (OVERTIME_WORK, dur);
   }

   /**
    * Returns the cost  of this resource assignment
    *
    * @return cost
    * @see #COST CONSTANTS for description
    */
   public Number getCost ()
   {
      return ((Number)get(COST));
   }

   /**
    * Sets the cost for this resource assignment
    * @param val cost
    * @see #COST CONSTANTS for description
    */
   public void setCost (Number val)
   {
      putCurrency (COST, val);
   }

   /**
    * Returns the planned cost for this resource assignment
    *
    * @return planned cost
    * @see #PLANNED_COST CONSTANTS for description
    */
   public Number getPlannedCost ()
   {
      return ((Number)get(PLANNED_COST));
   }

   /**
    * Sets the planned cost for this resource assignment
    *
    * @param val planned cost
    * @see #PLANNED_COST CONSTANTS for description
    */
   public void setPlannedCost (Number val)
   {
      putCurrency (PLANNED_COST, val);
   }

   /**
    * Returns the actual cost for this resource assignment
    * @return actual cost
    * @see #ACTUAL_COST CONSTANTS for description
    */
   public Number getActualCost ()
   {
      return ((Number)get(ACTUAL_COST));
   }

   /**
    * Sets the actual cost so far incurred for this resource assignment
    *
    * @param val actual cost
    * @see #ACTUAL_COST CONSTANTS for description
    */
   public void setActualCost (Number val)
   {
      putCurrency (ACTUAL_COST, val);
   }

   /**
    * Returns the start of this resource assignment
    *
    * @return start date
    * @see #START CONSTANTS for description
    */
   public Date getStart ()
   {
      return ((Date)get(START));
   }

   /**
    * Sets the start date for this resource assignment
    *
    * @param val start date
    * @see #START CONSTANTS for description
    */
   public void setStart (Date val)
   {
      putDate (START, val);
   }

   /**
    * Returns the finish date for this resource assignment
    *
    * @return finish date
    * @see #FINISH CONSTANTS for description
    */
   public Date getFinish ()
   {
      return ((Date)get(FINISH));
   }

   /**
    * Sets the finish date for this resource assignment
    *
    * @param val finish date
    * @see #FINISH CONSTANTS for description
    */
   public void setFinish (Date val)
   {
      putDate (FINISH, val);
   }

   /**
    * Returns the delay for this resource assignment
    *
    * @return delay
    * @see #DELAY CONSTANTS for description
    */
   public MPXDuration getDelay ()
   {
      return ((MPXDuration)get(DELAY));
   }

   /**
    * Sets the delay for this resource assignment
    * @param dur delay
    * @see #DELAY CONSTANTS for description
    */
   public void setDelay (MPXDuration dur)
   {
      put (DELAY, dur);
   }

   /**
    * Returns the resources unique id for this resource assignment
    * @return resources unique id
    * @see #RESOURCE_UNIQUE_ID CONSTANTS for description
    */
   public int getResourceUniqueIDValue ()
   {
      return (getIntValue(RESOURCE_UNIQUE_ID));
   }

   /**
    * Returns the resources unique id for this resource assignment
    * @return resources unique id
    * @see #RESOURCE_UNIQUE_ID CONSTANTS for description
    */
   public Integer getResourceUniqueID ()
   {
      return ((Integer)get (RESOURCE_UNIQUE_ID));
   }

   /**
    * Sets the resources unique id for this resource assignment
    *
    * @param val resources unique id
    * @see #RESOURCE_UNIQUE_ID CONSTANTS for description
    */
   public void setResourceUniqueID (int val)
   {
      put (RESOURCE_UNIQUE_ID, val);
   }

   /**
    * Sets the resources unique id for this resource assignment
    *
    * @param val resources unique id
    * @see #RESOURCE_UNIQUE_ID CONSTANTS for description
    */
   public void setResourceUniqueID (Integer val)
   {
      put (RESOURCE_UNIQUE_ID, val);
   }

   /**
    * Gets the Resource Assignment Workgroup Fields if one exists
    * @return workgroup assignment object
    */
   public ResourceAssignmentWorkgroupFields getWorkgroupAssignment ()
   {
      return (m_workgroup);
   }

   /**
    * This method retrieves a reference to the task with which this
    * assignment is associated.
    *
    * @return task
    */
   public Task getTask ()
   {
      return (m_task);
   }

   /**
    * This method retrieves a reference to the resource with which this
    * assignment is associated.
    *
    * @return resource
    */
   public Resource getResource ()
   {
      return (getParentFile().getResourceByUniqueID(getResourceUniqueIDValue()));
   }

   /**
    * This method generates a string in MPX format representing the
    * contents of this record.
    *
    * @return string containing the data for this record in MPX format.
    */
   public String toString()
   {
      StringBuffer buf = new StringBuffer();

      buf.append(toString(RECORD_NUMBER));

      if (m_workgroup != null)
      {
         buf.append (m_workgroup.toString());
      }

      return (buf.toString());
   }

   /**
    * Reference to the parent task of this assignment
    */
   private Task m_task;

   /**
    *  Child record for Workgroup fields.
    */
   private ResourceAssignmentWorkgroupFields m_workgroup;

   /**
    * Default units value: 100%
    */
   public static final Double DEFAULT_UNITS = new Double (100);

   /**
    * ID of the resource.
    */
   private static final int RESOURCE_ID = 0;

   /**
    * Units assigned
    */
   private static final int UNITS = 1;

   /**
    * The Work field shows the total amount of work scheduled to be performed
    * by a resource on a task. This field shows the total work, or person-hours,
    * scheduled for an assignment.
    */
   private static final int WORK = 2;

   /**
    * The Planned Work field shows the amount of work planned to be done by
    * a resource on a task.
    */
   private static final int PLANNED_WORK = 3;

   /**
    * The Actual Work field shows the amount of work that has already been
    * done by a resource on a task.
    */
   private static final int ACTUAL_WORK = 4;

   /**
    * The Overtime Work field shows the amount of overtime to be performed
    * by a resource on a task, and charged at the resource's overtime rate.
    */
   private static final int OVERTIME_WORK = 5;

   /**
    * The Cost field shows the total scheduled, or projected, cost for a
    * resource assignment.
    * This is based on costs already incurred for work performed by the
    * resource on a task,
    * in addition to the costs planned for the remaining work for the
    * assignment. This is also
    * referred to as estimate at completion (EAC).
    */
   private static final int COST = 6;

   /**
    * The Planned Cost field shows costs for work planned to be performed
    * by a resource on a task.
    */
   private static final int PLANNED_COST = 7;

   /**
    * The Actual Cost field shows costs incurred for work already performed
    * by a resource on a task. You can enter all the actual costs or have
    * Microsoft Project calculate them for you
    */
   private static final int ACTUAL_COST = 8;

   /**
    * The Start field contains the date and time that an assigned resource
    * is scheduled
    * to begin working on a task. You can enter the start date you want,
    * to indicate the
    * date when the assignment should start. Or, you can have
    * Microsoft Project calculate
    * the start date.
    */
   private static final int START = 9;

   /**
    * The Finish field shows the date and time that an assigned resource is
    * scheduled to
    * complete work on a task. You can enter the finish date you want, to
    * indicate the date
    * when the assignment should be completed. Or, you can have Microsoft
    * Project calculate
    * the finish date.
    */
   private static final int FINISH = 10;

   /**
    * Delay
    */
   private static final int DELAY = 11;

   /**
    * Unique ID of the resource
    */
   private static final int RESOURCE_UNIQUE_ID = 12;

   /**
    * Maximum number of fields in this record.
    */
   private static final int MAX_FIELDS = 13;

   /**
    * Constant containing the record number associated with this record.
    */
   public static final int RECORD_NUMBER = 75;
}